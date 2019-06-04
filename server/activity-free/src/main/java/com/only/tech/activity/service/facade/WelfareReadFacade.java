package com.only.tech.activity.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.AccountChangeTypeConstants;
import com.only.tech.constant.ActivityConstants;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.entity.user.ReadTimePerday;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.enums.InvitationTaskEnum;
import com.only.tech.exposeinfz.user.api.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * facade: 阅读福利
 * @author shutong
 * @since 2019/05/06
 */
@Slf4j
@Service
public class WelfareReadFacade {

    @Reference
    private CustomerInfz customerInfz;

    @Reference
    private CustomerAccountInfz accountInfz;

    @Reference
    private ReadTimePerdayInfz readTimePerdayInfz;

    @Reference
    private AccountFlowRecordInfz flowRecordInfz;

    @Reference
    private InvitationInfz invitationInfz;

    @Autowired
    private ExtraBonusFacade extraBonusFacade;

    /**
     * 获取30秒阅读福利
     * @param cuId
     * @return
     */
    public ResultDto get30sWelfareRead(Long cuId) {

        Customer customer=this.customerInfz.getOneByCuid(cuId);
        if(customer==null){
            return ResultDto.errorResult("用户信息不存在");
        }

        CustomerAccount account=this.accountInfz.getOneByCuid(cuId);
        if(account==null){
            return ResultDto.errorResult("账户信息不存在");
        }

        Date now=new Date();
        String ymd=new SimpleDateFormat("yyyy-MM-dd").format(now);
        ReadTimePerday readTimePerday=this.readTimePerdayInfz.getOneByCondition(cuId,ymd);
        Integer cusReadTime=null;
        if(readTimePerday==null){
            readTimePerday=new ReadTimePerday();
            readTimePerday.setTimeCount(30);
            readTimePerday.setCuId(cuId);
            readTimePerday.setLastReadTime(now);
            readTimePerday.setReadDate(ymd);
            readTimePerday.setAwardStatus(0);
            cusReadTime=30;
        }else{
            //如果距离上一次时间间隔小于30秒，返回异常
            Long diffTime=now.getTime()-readTimePerday.getLastReadTime().getTime();
            if(diffTime<30000){
                return ResultDto.errorResult("时间间隔小于30秒");
            }
            cusReadTime=readTimePerday.getTimeCount()+ActivityConstants.SECOND_30;
            readTimePerday.setTimeCount(cusReadTime);
            readTimePerday.setLastReadTime(now);
        }

        //判断是否奖励（ 30分钟奖100金豆、60分钟奖150金豆、90分钟奖300金豆、180分钟奖500金豆 ）
        Integer awardStatus=readTimePerday.getAwardStatus();
        Integer goldBean=null;
        String awardMark=null;
        String awardFlag="30s"; //30s :30秒常规福利  | day :每日福利
        if(cusReadTime == ActivityConstants.SECOND_1800 && awardStatus < ActivityConstants.AWARD_STATUS_30){          //30分钟福利150金豆
            goldBean=ActivityConstants.GOLDBEAN_180;
            awardStatus=ActivityConstants.AWARD_STATUS_30;
            awardMark=ActivityConstants.AWARD_MARK_30;
            awardFlag="day";
        }
        else if(cusReadTime == ActivityConstants.SECOND_3600 && awardStatus < ActivityConstants.AWARD_STATUS_60){    //60分钟福利180金豆
            goldBean=ActivityConstants.GOLDBEAN_150;
            awardStatus=ActivityConstants.AWARD_STATUS_60;
            awardMark=ActivityConstants.AWARD_MARK_60;
            awardFlag="day";
        }
        else if(cusReadTime == ActivityConstants.SECOND_5400 && awardStatus < ActivityConstants.AWARD_STATUS_90){    //90分钟福利150金豆
            goldBean=ActivityConstants.GOLDBEAN_300;
            awardStatus=ActivityConstants.AWARD_STATUS_90;
            awardMark=ActivityConstants.AWARD_MARK_90;
            awardFlag="day";
        }
        else if(cusReadTime == ActivityConstants.SECOND_10800 && awardStatus < ActivityConstants.AWARD_STATUS_180){  //180分钟福利150金豆
            goldBean=ActivityConstants.GOLDBEAN_500;
            awardStatus=ActivityConstants.AWARD_STATUS_180;
            awardMark=ActivityConstants.AWARD_MARK_180;
            awardFlag="day";
        }
        else {                                                                                                     //常规30福利150金豆
            goldBean=new Random().nextInt(ActivityConstants.WELFARE_30S_READ_NUMBER_MAX); //0-66随机金豆
            awardMark=ActivityConstants.AWARD_MARK_NORMAL+goldBean;
        }

        //修改用户金豆信息
        Long newGoldBean=account.getGold()+goldBean;
        account.setGold(newGoldBean);
        this.accountInfz.saveOrUpdate(account);

        //修改当日阅读时长 & 阅读福利状态
        readTimePerday.setAwardStatus(awardStatus);
        this.readTimePerdayInfz.saveOrUpdate(readTimePerday);

        //创建获奖流水记录-记录每日阅读福利，不记录30S常规福利
        AccountFlowRecord flowRecord=new AccountFlowRecord();
        flowRecord.setAmount(goldBean.longValue());
        flowRecord.setChangeType(AccountChangeTypeConstants.REWARD); //福利
        AccountChangeSpecificTypeEnum specificType = AccountChangeSpecificTypeEnum.READ_30_SECONDS_AWARD;
        if(!"30s".equals(awardFlag)){
            int minute = cusReadTime / 60;
            specificType = AccountChangeSpecificTypeEnum.READ_MINUTE_AWARD;
            specificType.setRemark(minute+"");
        }
        flowRecord.setSpecificType(specificType.getType());
        flowRecord.setCreateTime(now);
        flowRecord.setCurrencyType(CurrencyTypeEnum.GOLD.getType()); //金豆
        flowRecord.setRemark(awardMark);
        flowRecord.setTitle(specificType.getName());
        flowRecord.setCuId(cuId);
        this.flowRecordInfz.saveOrUpdate(flowRecord);

        //记录额外奖励
        extraBonusFacade.addReadAwards(cuId,goldBean.longValue());


        //完成阅读任务，奖励推荐人
        switch (cusReadTime){
            case ActivityConstants.SECOND_900:
                invitationInfz.finishTask(cuId, InvitationTaskEnum.FINISH_ONE,now);
                break;
            case ActivityConstants.SECOND_1800:
                invitationInfz.finishTask(cuId, InvitationTaskEnum.FINISH_TWO,now);
                break;
            case ActivityConstants.SECOND_3600:
                invitationInfz.finishTask(cuId, InvitationTaskEnum.FINISH_THREE,now);
                break;
        }


        return ResultDto.succesResult(awardMark);
    }

}
