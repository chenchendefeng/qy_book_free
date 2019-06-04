package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.ExchangeOrderDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.entity.user.ExchangeOrder;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.enums.ExchangeOrderStatusEnum;
import com.only.tech.exposeinfz.user.api.ExchangeOrderInfz;
import com.only.tech.user.service.biz.CustomerAccountService;
import com.only.tech.user.service.biz.CustomerService;
import com.only.tech.user.service.biz.ExchangeOrderService;
import com.only.tech.user.service.facade.AccountFlowRecordFacade;
import com.only.tech.user.service.facade.CustomerAccountFacade;
import com.only.tech.user.service.facade.ExchangeOrderFacade;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Component
@Service(interfaceClass = ExchangeOrderInfz.class)
public class ExchangeOrderInfzImpl implements ExchangeOrderInfz{

    @Autowired
    private ExchangeOrderService exchangeOrderService;

    @Autowired
    private ExchangeOrderFacade exchangeOrderFacade;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerAccountService customerAccountService;

    @Autowired
    private AccountFlowRecordFacade accountFlowRecordFacade;


    @Override
    public PageData<ExchangeOrderDto> page(Long cuId, Integer orderStatus, String startTime, String endTime, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());

        exchangeOrderService.dtoList(cuId,orderStatus,startTime,endTime);

        PageData pageData = new PageData(page);

        return pageData;
    }

    @Override
    public ResultDto audit(String orderNo, Integer status, String remark) {
        ExchangeOrder order = exchangeOrderService.getByOrderNo(orderNo);
        if (order == null){
            return ResultDto.errorResult("订单不存在");
        }
        Integer orderStatus = order.getOrderStatus();
        if (orderStatus == 0){
            order.setOrderStatus(status);
            Date now = new Date();
            order.setAuditTime(now);
            order.setRemark(remark);

            exchangeOrderService.updateById(order);
            if (status.equals(ExchangeOrderStatusEnum.AUDIT_FAIL.getStatus())){

                Long cuId = order.getCuId();
                String exchangeType = order.getExchangeType();
                Integer cost = order.getCost();
                CustomerAccount account = customerAccountService.getCuId(cuId);
                if (CurrencyTypeEnum.GOLD.getType().equals(exchangeType)){
                    Long gold = account.getGold();
                    account.setGold(gold + cost);
                    customerAccountService.updateById(account);
                    accountFlowRecordFacade.record(cuId,CurrencyTypeEnum.GOLD,cost.longValue(), AccountChangeTypeEnum.WITHDRAWAL_RETURN,null,null);
                }else {
                    Long accountRmb = account.getRmb();
                    long amount = Long.valueOf(cost * 100);
                    account.setRmb(accountRmb + amount);
                    customerAccountService.updateById(account);
                    accountFlowRecordFacade.record(cuId,CurrencyTypeEnum.RMB,amount, AccountChangeTypeEnum.WITHDRAWAL_RETURN,null,null);
                }
            }

            return ResultDto.succesResult("审核完成");

        }

        return ResultDto.errorResult("订单已经审核结束");
    }


    @Override
    @Async
    public void sendRedPacket() {
        //查询审核成功的订单
        QueryWrapper qw = new QueryWrapper();
        qw.eq("orderStatus", ExchangeOrderStatusEnum.AUDIT_SUCCESS.getStatus());

        int pageNo = 1;
        int maxPage = 0;
        do {
            Page page = PageHelper.startPage(pageNo,1000);
            List<ExchangeOrder> list = exchangeOrderService.list(qw);
            if (!list.isEmpty()) {
                for (ExchangeOrder order: list) {
                    Customer customer = customerService.getByCuId(order.getCuId());
                    if (customer != null && StringUtils.isNotBlank(customer.getBindOpenid())){
                        send(customer.getBindOpenid(),order.getOrderNo(),order.getRmbAmount());
                    }
                }
            }

            pageNo++;
            maxPage = page.getPages();
        }while (pageNo <= maxPage);
    }

    @Async
    public boolean send(String openid,String orderNo,Integer rmbAmount){
        try {
            exchangeOrderFacade.sendRedPacket(openid,orderNo,rmbAmount);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public void sendCheck() {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("orderStatus", ExchangeOrderStatusEnum.WX_PROCESSING.getStatus());

        int pageNo = 1;
        int maxPage = 0;
        do {
            Page page = PageHelper.startPage(pageNo,1000);
            List<ExchangeOrder> list = exchangeOrderService.list(qw);
            if (!list.isEmpty()) {
                for (ExchangeOrder order: list) {
                    check(order.getOrderNo());
                }
            }

            pageNo++;
            maxPage = page.getPages();
        }while (pageNo <= maxPage);
    }

    @Async
    public void check(String orderNo) {

        try {
            exchangeOrderFacade.checkOrderSendStatus(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
