package com.only.tech.user.service.facade;

import com.only.tech.base.utils.LocalDateUtils;
import com.only.tech.entity.user.VipGoods;
import com.only.tech.entity.user.VipRecord;
import com.only.tech.user.service.biz.PayRecordService;
import com.only.tech.user.service.biz.VipGoodsService;
import com.only.tech.user.service.biz.VipRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/23
 */
@Slf4j
@Service
public class UserVipFacade {


    @Autowired
    private VipGoodsService vipGoodsService;

    @Autowired
    private PayRecordService iUPayRecordService;

    @Autowired
    private VipRecordService iUVipRecordService;


    @Transactional(rollbackFor = Exception.class)
    public Boolean buyVip(Long uid, Long vipId, String payOrderNo, String systemType){

        VipGoods goods = this.vipGoodsService.getById(vipId);
        if (goods == null) {
            log.error("UserVipInfz.userBuyVip error:can not find vipGoods by vipId,vipId={},payOrderNo={},uid={}",
                    vipId, payOrderNo, uid);
            return false;
        }
        // 查询订单是否有效
        if (iUPayRecordService.isOutTradeNoUsed(payOrderNo)) {
            log.error("UserVipInfz.userBuyVip error:payOrderNo is already used,vipId={},payOrderNo={},uid={}",
                    vipId, payOrderNo, uid);
            return false;
        }

        // 首充队列
        addUserVip(uid, vipId, payOrderNo, systemType, goods);
        return true;
    }

    /**
     * 给用户添加vip
     *
     * @param uid
     * @param vipId
     * @param payOrderNo
     * @param systemType
     * @param goods
     */
    private void addUserVip(Long uid, Long vipId, String payOrderNo, String systemType, VipGoods goods) {
        VipRecord vip = iUVipRecordService.selectVipInfoByUid(uid);
        Integer type = goods.getType();

        if (vip != null) {
            //判断当前会员是否有效
            String vipExpireDate = vip.getVipExpireDate();
            if(LocalDateUtils.isBeforeNow(vipExpireDate)){//当前会员无效，修改成会员状态
                //会员无效，时间从当前开始计算
                vip.setVipExpireDate(LocalDateUtils.getPlusDayStr(null, goods.getEffectiveDays()));
            }else {
                //会员有效，时间累加
                vip.setVipExpireDate(LocalDateUtils.getPlusDayStr(vipExpireDate, goods.getEffectiveDays()));
            }
        } else {
            vip = new VipRecord();
            vip.setVipExpireDate(LocalDateUtils.getPlusDayStr(null, goods.getEffectiveDays()));
        }

        vip.setUid(uid);
        vip.setVipType(type>1 ? type : 1);
        // 更新用户的vip时间
        iUVipRecordService.saveOrUpdateByUid(vip);
        // 插入支付记录表
        iUPayRecordService.saveByOrderNo(uid, payOrderNo, null, vipId, goods.getPrice(), systemType);
    }


}
