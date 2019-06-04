package com.only.tech.user.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultEnum;
import com.only.tech.constant.Constants;
import com.only.tech.constant.UserConstants;
import com.only.tech.constant.UserRedisKeyConstants;
import com.only.tech.entity.user.*;
import com.only.tech.enums.*;
import com.only.tech.exposeinfz.payment.api.WxRedPacketInfz;
import com.only.tech.user.dto.ExchangeOrderBaseDto;
import com.only.tech.user.service.biz.*;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.exception.BusinessException;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.NumUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Slf4j
@Service
public class ExchangeOrderFacade {

    @Autowired
    private ExchangeOrderService exchangeOrderService;

    @Autowired
    private ExchangeGoodsService exchangeGoodsService;

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private SystemConfigService configService;

    @Autowired
    private AccountFlowRecordFacade accountFlowRecordFacade;

    @Autowired
    private ReadTimePerdayService readTimePerdayService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedpacketResultService redpacketResultService;

    @Autowired
    private RedpacketCheckResultService redpacketCheckResultService;

    @Reference
    private WxRedPacketInfz wxRedPacketInfz;


    public PageData<ExchangeOrderBaseDto> page(Long cuId, PageReq pageReq) {
        Page<ExchangeOrderBaseDto> page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());

        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.orderByDesc("createTime");

        exchangeOrderService.list(qw);

        PageData pageData = new PageData(page);
        return pageData;
    }


    /**
     * 兑换提现
     * @param cuId
     * @param goodsId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto exchange(Long cuId, Integer goodsId) {
        /**校验参数*/
        ExchangeGoods goods = exchangeGoodsService.getById(goodsId);
        if (goods == null){
            return ResultDto.errorResult("商品不存在");
        }
        Integer status = goods.getStatus();
        if (status != 1){
            return ResultDto.errorResult("商品无效");
        }
        Customer customer = customerFacade.getByCuid(cuId);
        if (customer == null){
            return ResultDto.errorResult("用户不存在");
        }
        String bindOpenid = customer.getBindOpenid();
        if (StringUtils.isBlank(bindOpenid)){
            return ResultDto.errorResult("未绑定微信");
        }
        //礼品兑换条件
        Date now = new Date();
        String requirement = goods.getRequirement();
        if (UserConstants.VIP.equals(requirement)){
            //会员
            boolean isVip = customerFacade.isVIP(cuId);
            if (!isVip){
                return ResultDto.errorResult("会员专享礼品");
            }

        }else if (UserConstants.READTIME.equals(requirement)){
            //阅读时间
            Integer readTime = readTimePerdayService.getReadTime(cuId, DateFormatUtil.formatShort(now));
            Integer requirementNumber = goods.getRequirementNumber();
            if (readTime-requirementNumber < 0){
                return ResultDto.errorResult("阅读时间需达到" + requirementNumber + "秒才能提现此礼品");
            }
        }


        /**兑换*/
        Integer rmbAmount = 0;
        CurrencyTypeEnum currencyType = null;
        String exchangeType = goods.getExchangeType();
        Integer cost = goods.getCost();
        CustomerAccount account = customerAccountFacade.getCuId(cuId);

        Long originalBalance = null;
        Long restBalance = null;
        if (exchangeType.equals(CurrencyTypeEnum.GOLD.getType())){
            currencyType = CurrencyTypeEnum.GOLD;
            Long accountGold = account.getGold();

            long restGold = accountGold - cost;

            if (restGold < 0){
                return ResultDto.errorResult("金豆余额不足");
            }

            originalBalance = accountGold;
            restBalance = restGold;
            //金币兑换
            SystemConfig config = configService.getBype(Constants.EXCHANGE_RATIO);
            if (config == null){
                return ResultDto.errorResult("兑换比例错误");
            }
            Integer rmb = config.getNumber1();//单位分
            Integer gold = config.getNumber2();
            double ratio = NumUtil.div(gold,rmb);
            if (ratio <= 0){
                return ResultDto.errorResult("兑换比例错误");
            }

            Double amount = NumUtil.div(cost,ratio);
            rmbAmount = amount.intValue();

            account.setGold(restGold);

        }else if (exchangeType.equals(CurrencyTypeEnum.RMB.getType())){
            //人民币提现
            currencyType = CurrencyTypeEnum.RMB;
            Long accountRmb = account.getRmb();
            long restRmb = accountRmb - cost;
            if (restRmb < 0) {
                return ResultDto.errorResult("余额不足");
            }
            originalBalance = accountRmb;
            restBalance = restRmb;
            rmbAmount = cost;

            account.setRmb(restRmb);
        }
        boolean update = customerAccountFacade.update(account);
        if (update){
            //流水
            accountFlowRecordFacade.record(cuId,currencyType,cost.longValue(), AccountChangeTypeEnum.WITHDRAWAL,null,null);

            //提现订单
            ExchangeOrder order = new ExchangeOrder();
            order.setCuId(cuId);
            String orderNo = getOrderNo(cuId,now);
            order.setOrderNo(orderNo);
            order.setGoodsName(goods.getName());
            order.setExchangeType(goods.getExchangeType());
            Integer goodsCost = cost;
            if (exchangeType.equals(CurrencyTypeEnum.RMB.getType())){
                Double div = NumUtil.div(cost, 100);
                goodsCost = div.intValue();
            }
            order.setCost(goodsCost);//若为人民币单位是元
            order.setRmbAmount(rmbAmount);
            order.setCreateTime(now);
            order.setNoDeduction(originalBalance);
            order.setDeductioned(restBalance);
            int orderStatus = ExchangeOrderStatusEnum.AUDITING.getStatus();
            //小于一元直接审核通过
            if (rmbAmount <= 100){
                order.setAuditTime(now);
                order.setAuditorId(1);
                orderStatus = ExchangeOrderStatusEnum.AUDIT_SUCCESS.getStatus();
                order.setOrderStatus(orderStatus);
            }
            boolean save = exchangeOrderService.save(order);
            if (save ){
                if ( ExchangeOrderStatusEnum.AUDIT_SUCCESS.getStatus().equals(orderStatus)){
                    /**发微信红包*/
                    return sendRedPacket(bindOpenid,orderNo,rmbAmount);
                }else if (ExchangeOrderStatusEnum.AUDITING.getStatus().equals(orderStatus)){
                    return ResultDto.succesResult("申请成功，正在审核");
                }
            }
        }

        return ResultDto.succesResult("提现失败");
    }

    /**
     * 发送红包
     * @param bindOpenid
     * @param orderNo
     * @param rmbAmount
     * @return
     */
    public ResultDto sendRedPacket(String bindOpenid, String orderNo, Integer rmbAmount) {
        //发红包
        RedpacketResult redpacketResult = wxRedPacketInfz.sendRedPacket(bindOpenid, orderNo, rmbAmount);
        ResultEnum resultEnum = ResultEnum.ERROR;

        if (redpacketResult != null){
            String returnCode = redpacketResult.getReturnCode();
            if (StringUtils.isNotBlank(returnCode) && Constants.STR_SUCCESS.equals(returnCode)){

                redpacketResultService.save(redpacketResult);

                String resultCode = redpacketResult.getResultCode();
                if(StringUtils.isNotBlank(resultCode) && Constants.STR_SUCCESS.equals(resultCode)){
                    String mchBillno = redpacketResult.getMchBillno();
                    ExchangeOrder order = exchangeOrderService.getByOrderNo(mchBillno);
                    if (order != null){
                        order.setOrderStatus(ExchangeOrderStatusEnum.SEND_REDPACKET_SUCCESS.getStatus());
                        exchangeOrderService.updateById(order);
                        //发送成功
                        return ResultDto.succesResult("申请成功");
                    }

                }else {
                    String errCode = redpacketResult.getErrCode();
                    if (StringUtils.isNotBlank(errCode)){
                        RedPackErrCodeEnum errCodeEnum = RedPackErrCodeEnum.valueOf(errCode);
                        if (errCodeEnum != null && errCodeEnum.equals(RedPackErrCodeEnum.PROCESSING)){
                            //微信正在发送红包
                            String mchBillno = redpacketResult.getMchBillno();
                            ExchangeOrder order = exchangeOrderService.getByOrderNo(mchBillno);
                            if (order != null){
                                order.setOrderStatus(ExchangeOrderStatusEnum.WX_PROCESSING.getStatus());
                                exchangeOrderService.updateById(order);
                                return ResultDto.succesResult("申请成功");
                            }
                        }
                        log.error("发送红包失败：errCode:[{}];msg:[{}]",errCode,errCodeEnum.getMsg());
                    }
                }
            }else {
                log.error("发送红包请求失败，orderNo:[{}]",orderNo);
                resultEnum.setMsg("发送红包错误");
            }
        }
        throw new BusinessException(resultEnum);
    }


    /**
     * 兑换提现订单号
     * @param cuId
     * @param date
     * @return
     */
    private String getOrderNo(Long cuId,Date date) {
        StringBuffer sb = new StringBuffer();
        sb.append(cuId);
        sb.append(UserConstants.EXCHANGE_PREFIX);
        sb.append(DateFormatUtil.getFormatLongFull(date));
        int random = NumUtil.getRandom(1, 100);
        sb.append(random);
        String orderNo = sb.toString();
        String redisKey = UserRedisKeyConstants.EXCHANGE_ORDERNO_KEY + orderNo;
        Object redisValue = redisTemplate.opsForValue().get(redisKey);
        if (redisValue != null){
            return getOrderNo(cuId,date);
        }
        redisTemplate.opsForValue().set(redisKey,1,30, TimeUnit.MINUTES);
        return orderNo;
    }


    /**
     * 提现广播消息
     * @param pageReq
     * @return
     */
    public PageData<String> msgPage(PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("orderStatus",ExchangeOrderStatusEnum.SEND_REDPACKET_SUCCESS.getStatus());
        qw.orderByDesc("createTime");
        List<ExchangeOrder> list = exchangeOrderService.list(qw);

        PageData pageData = new PageData(page);
        if (!list.isEmpty()) {
            List<String> msgList = new ArrayList<>();
            for (ExchangeOrder order: list) {
                Long cuId = order.getCuId();
                Customer customer = customerFacade.getByCuid(cuId);
                if (customer != null){
                    StringBuffer sb = new StringBuffer();
                    String nickName = customer.getNickName();
                    sb.append(nickName);
                    sb.append(" 刚提现了");
                    Integer rmbAmount = order.getRmbAmount();
                    double money = NumUtil.div(rmbAmount, 100);
                    sb.append(money);
                    sb.append("元至微信账户");
                    msgList.add(sb.toString());
                }
            }
            pageData.setData(msgList);
        }
        return pageData;
    }

    /**
     * 检查订单红包发送状态
     * @param orderNo
     */
    public void checkOrderSendStatus(String orderNo) throws Exception {

        RedpacketCheckResult result = wxRedPacketInfz.sendCheck(orderNo);
        if (result != null){
            String mchBillno = result.getMchBillno();
            if (StringUtils.isBlank(mchBillno)){
                return;
            }
            boolean save = redpacketCheckResultService.save(result);
            if (!save){
                return;
            }

            String returnCode = result.getReturnCode();
            if (StringUtils.isNotBlank(returnCode) && Constants.STR_SUCCESS.equals(returnCode)){
                String resultCode = result.getResultCode();
                ExchangeOrder order = exchangeOrderService.getByOrderNo(orderNo);
                Integer orderStatus = order.getOrderStatus();
                if(StringUtils.isNotBlank(resultCode) && Constants.STR_SUCCESS.equals(resultCode)){
                    String status = result.getStatus();
                    RedpacketStatusEnum statusEnum = RedpacketStatusEnum.valueOf(status);
                    switch (statusEnum){
                        case SENDING:
                            orderStatus = ExchangeOrderStatusEnum.WX_PROCESSING.getStatus();
                            break;
                        case FAILED:
                            orderStatus = ExchangeOrderStatusEnum.SEND_REDPACKET_FAIL.getStatus();
                            break;
                        default:
                            orderStatus = ExchangeOrderStatusEnum.SEND_REDPACKET_SUCCESS.getStatus();
                            break;
                    }
                }else {
                    log.error("检查后边失败：errCode:[{}];errCodeDes:[{}]",result.getErrCode(),result.getErrCodeDes());
                }
                order.setOrderStatus(orderStatus);
                exchangeOrderService.updateById(order);
            }else {
                log.error("检查后边失败：returnCode:[{}];returnMsg:[{}]",returnCode,result.getReturnMsg());
            }
        }

    }
}
