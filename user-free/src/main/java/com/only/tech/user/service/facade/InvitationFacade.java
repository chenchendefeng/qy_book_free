package com.only.tech.user.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.ActivityConstants;
import com.only.tech.constant.UserConstants;
import com.only.tech.entity.activity.ReceiveWelfare;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.InvitationRecord;
import com.only.tech.enums.*;
import com.only.tech.exposeinfz.activity.api.ExtraBonusInfz;
import com.only.tech.exposeinfz.activity.api.ReceiveWelfareInfz;
import com.only.tech.user.common.utils.AlgorithmUtil;
import com.only.tech.user.dto.InvitationRecordDto;
import com.only.tech.user.service.biz.CustomerService;
import com.only.tech.user.service.biz.InvitationRecordService;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.NumUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/13
 */
@Service
public class InvitationFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private InvitationRecordService invitationRecordService;

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private AccountFlowRecordFacade accountFlowRecordFacade;

    @Autowired
    private FriendFacade friendFacade;

    @Reference
    private ExtraBonusInfz extraBonusInfz;

    @Reference
    private ReceiveWelfareInfz receiveWelfareInfz;


    @Transactional(rollbackFor = Exception.class)
    public String getCode(Long cuId) {
        Customer customer = customerService.getByCuId(cuId);
        if (customer == null){
            return null;
        }

        String invitationCode = customer.getInvitationCode();
        if (StringUtils.isBlank(invitationCode)){
            invitationCode = AlgorithmUtil.getCode(6, null, true, true, true);
            Customer cus = customerService.getByInvitationCode(invitationCode);
            if (cus != null){
                return getCode(cuId);
            }
            customer.setInvitationCode(invitationCode);
            customerService.updateByCuId(customer);
        }

        return invitationCode;

    }


    /**
     * 填写邀请码
     * @param invitedCuid
     * @param invitationCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto fillInCode(Long invitedCuid, String invitationCode) {

        //添加邀请记录
        Customer customer = customerService.getByInvitationCode(invitationCode);
        if (customer == null){
            return ResultDto.errorResult("邀请码不正确");
        }
        if (invitedCuid.equals(customer.getCuId())){
            return ResultDto.errorResult("不能填自己的邀请码");
        }

        Long cuId = customer.getCuId();
        InvitationRecord record = invitationRecordService.getByCuidAndInvitedCuid(cuId,invitedCuid);
        if (record != null){
            return ResultDto.errorResult("重复填写");
        }
        record = new InvitationRecord();
        record.setCuId(cuId);
        record.setInvitedCuid(invitedCuid);
        Date now = new Date();
        record.setCreateTime(now);
        Customer invitedCustomer = customerService.getByCuId(invitedCuid);
        if (invitedCustomer == null){
            return ResultDto.errorResult("用户数据错误");
        }
        Date regDate = invitedCustomer.getRegDate();
        record.setTaskStatus(InvitationTaskEnum.NOT_START.getCode());
        String endDate = DateFormatUtil.getEndDate(regDate);
        record.setTaskExpiryTime(DateFormatUtil.parse(endDate));
        boolean save = invitationRecordService.save(record);

        //注册24小时之内邀请用户，添加额外阅读奖励
        Date expiryTime = DateFormatUtil.addHour(regDate, 24);
        if (DateFormatUtil.compareDate(expiryTime,now) > 0){
            extraBonusInfz.addMultiple(cuId,expiryTime);
        }

        //奖励被邀请人
        if (save){
            Integer award = award(invitedCuid);
            double rmb = NumUtil.div(new Double(award), 100L);

            //记录领取福利
            ReceiveWelfare receiveWelfare = new ReceiveWelfare();
            receiveWelfare.setCuId(invitedCuid);
            receiveWelfare.setType(ActivityConstants.NOVICE);
            receiveWelfare.setWelfareType(WelfareTypeEnum.FILL_REDPACKET_CODE.getType());
            receiveWelfare.setDate(DateFormatUtil.formatShort(now));
            receiveWelfare.setCreateTime(now);
            receiveWelfareInfz.receive(receiveWelfare);

            //添加好友
            friendFacade.add(cuId,invitedCuid);

            return ResultDto.succesResult(rmb);
        }

        return ResultDto.errorResult("填写错误");
    }

    private Integer award(Long cuid) {
        Integer rmb = NumUtil.getRandom(1, 500);
        Long rmbL = Long.valueOf(rmb);
        boolean change = customerAccountFacade.rmbChange(cuid, rmbL);
        if (change){
            //加流水
            accountFlowRecordFacade.record(cuid, CurrencyTypeEnum.RMB,rmbL, AccountChangeTypeEnum.REWARD, AccountChangeSpecificTypeEnum.INVITATION_CODE_REDPACK,null);
        }
        return rmb;
    }

    /**
     * 邀请记录
     * @param cuId
     * @param pageReq
     * @return
     */
    public PageData<InvitationRecordDto> recordPage(Long cuId, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        List<InvitationRecord> list = invitationRecordService.listByCuid(cuId);

        PageData pageData = new PageData(page);
        if (!list.isEmpty()) {
            List<InvitationRecordDto> dtoList = new ArrayList<>();
            Date now = new Date();
            for (InvitationRecord record: list) {
                Long invitedCuid = record.getInvitedCuid();
                Customer customer = customerService.getByCuId(invitedCuid);
                if (customer != null){
                    InvitationRecordDto dto = new InvitationRecordDto();
                    dto.setCuId(customer.getCuId());
                    dto.setNickName(customer.getNickName());
                    dto.setAvatar(customer.getAvatar());
                    Date taskExpiryTime = record.getTaskExpiryTime();
                    Integer taskStatus = record.getTaskStatus();
                    dto.setFinishTimes(taskStatus);
                    if(DateFormatUtil.compareDate(now,taskExpiryTime) < 1){
                        dto.setRemind(1);
                        switch (taskStatus){
                            case 0:
                                dto.setRewardAmount(UserConstants.INVITATION_TASK_ONE_AWARD);
                                break;
                            case 1:
                                dto.setRewardAmount(UserConstants.INVITATION_TASK_TWO_AWARD);
                                break;
                            case 2:
                                dto.setRewardAmount(UserConstants.INVITATION_TASK_THREE_AWARD);
                                break;
                        }
                    }else {
                        dto.setRemind(0);
                    }
                    dtoList.add(dto);
                }
            }
            pageData.setData(dtoList);
        }

        return pageData;
    }


    public void finishTask(Long cuId, InvitationTaskEnum taskEnum, Date date) {
        InvitationRecord record = invitationRecordService.getByInvitedCuid(cuId);
        if (record != null) {
            Date expiryTime = record.getTaskExpiryTime();

            String dateStr = DateFormatUtil.formatShort(date);
            String expiryDateStr = DateFormatUtil.formatShort(expiryTime);
            //过期时间和阅读时间需在同一天
            if (!dateStr.equals(expiryDateStr)){
                return;
            }

            if (DateFormatUtil.compareDate(date,expiryTime) < 1){
                boolean update = false;
                Integer taskCode = taskEnum.getCode();
                Integer taskStatus = record.getTaskStatus();

                if ((taskCode.equals(UserConstants.INVITATION_TASK_ONE) && taskStatus.equals(UserConstants.INVITATION_TASK_UN_START))
                        || (taskCode.equals(UserConstants.INVITATION_TASK_TWO) && taskStatus.equals(UserConstants.INVITATION_TASK_ONE))
                        || (taskCode.equals(UserConstants.INVITATION_TASK_THREE) && taskStatus.equals(UserConstants.INVITATION_TASK_TWO))  ){
                    record.setTaskStatus(taskCode);
                    record.setTaskExpiryTime(DateFormatUtil.addDay(expiryTime,1));
                    update = invitationRecordService.updateById(record);
                }
                //奖励
                if (update){
                    awardInviter(record.getCuId(),taskEnum);
                }
            }
        }
    }


    public void awardInviter(Long cuId, InvitationTaskEnum taskEnum) {
        Integer taskCode = taskEnum.getCode();
        Long rmb = 0L;
        switch (taskCode){
            case 1:
                rmb = UserConstants.INVITATION_TASK_ONE_AWARD;
                break;
            case 2:
                rmb = UserConstants.INVITATION_TASK_TWO_AWARD;
                break;
            case 3:
                rmb = UserConstants.INVITATION_TASK_THREE_AWARD;
                break;
        }
        boolean change = customerAccountFacade.rmbChange(cuId, rmb);
        if (change){
            accountFlowRecordFacade.record(cuId,CurrencyTypeEnum.RMB,rmb,AccountChangeTypeEnum.REWARD,AccountChangeSpecificTypeEnum.INVITATION_REDPACK,null);
        }
    }
}
