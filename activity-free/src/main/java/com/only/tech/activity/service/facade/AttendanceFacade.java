package com.only.tech.activity.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.activity.common.constants.ConstantsActivity;
import com.only.tech.activity.common.dto.AttendanceCalendarDto;
import com.only.tech.activity.common.dto.AttendancePageDto;
import com.only.tech.activity.common.dto.AttendanceRewardDto;
import com.only.tech.activity.common.dto.AttendanceStatusDto;
import com.only.tech.activity.common.enums.AttendanceTypeEnum;
import com.only.tech.activity.service.biz.AttendanceCompensationService;
import com.only.tech.activity.service.biz.AttendanceService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultEnum;
import com.only.tech.entity.activity.Attendance;
import com.only.tech.entity.activity.AttendanceCompensation;
import com.only.tech.entity.activity.AttendanceReward;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.exposeinfz.user.api.CustomerAccountInfz;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.exception.BusinessException;
import ooh.chaos.util.DateFormatUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/9
 */
@Slf4j
@Service
public class AttendanceFacade {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private AttendanceRewardFacade attendanceRewardFacade;

    @Autowired
    private AttendanceCompensationService compensationService;

    @Reference
    private CustomerAccountInfz customerAccountInfz;


    /**
     * 签到
     * @param cuId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto sign(Long cuId) {
        Date now = new Date();
        String date = DateFormatUtil.formatShort(now);

        //检查是否签到
        boolean signed = attendanceService.signed(cuId,date);
        if (signed){
            return ResultDto.errorResult("重复签到");
        }

        //是否是第一次签到
        boolean isFirst = attendanceService.isFirst(cuId);

        Attendance attendance = new Attendance();
        attendance.setCuId(cuId);
        attendance.setAttendanceDate(date);
        attendance.setCreateTime(now);

        Integer times = 1;
        AttendanceTypeEnum typeEnum = AttendanceTypeEnum.DAILY_SIGN;
        if (isFirst){
            typeEnum = AttendanceTypeEnum.FIRST_SIGN;
        }else {
            String yesterday = DateFormatUtil.getYesterdayShort();
            Attendance yesRecord = attendanceService.getAttendance(cuId,yesterday);
            if (yesRecord != null){
                Integer yesTimes = yesRecord.getTimes();
                times = ++yesTimes;
            }
        }
        attendance.setTimes(times);
        attendance.setType(typeEnum.getCode());
        boolean save = attendanceService.save(attendance);

        if (save){
            //奖励
            Long amount = award(cuId, isFirst, times);
            if (amount != null){
                return ResultDto.succesResult(amount);
            }
        }

        return ResultDto.errorResult("签到失败");
    }

    private Long award(Long cuId, boolean isFirst, Integer times) {
        //获取奖励
        AttendanceReward reward = attendanceRewardFacade.getReward(isFirst,times);

        //入账加流水
        if (reward != null){
            String type = reward.getType();
            //日常签到
            Long amount = getAmount(times, reward);

            AccountChangeSpecificTypeEnum specificTypeEnum = null;
            switch (type){
                case ConstantsActivity.FIRST_SIGN://首签
                    specificTypeEnum = AccountChangeSpecificTypeEnum.FIRST_ATTENDANCE_AWARD;
                    break;
                case ConstantsActivity.DAILY_SIGN://日常签到
                    specificTypeEnum = AccountChangeSpecificTypeEnum.DAILY_ATTENDANCE_AWARD;
                    break;
                case ConstantsActivity.CONTINUITY_SIGN://连续签到
                    specificTypeEnum = AccountChangeSpecificTypeEnum.CONTINUITY_ATTENDANCE_AWARD;
                    specificTypeEnum.setRemark(times+"天");
                    break;
            }
            boolean rewarded = customerAccountInfz.attendanceChange(cuId, CurrencyTypeEnum.GOLD, amount, AccountChangeTypeEnum.REWARD, specificTypeEnum);
            if (rewarded){
                return amount;
            }
        }
        return null;
    }

    //奖励金额
    private Long getAmount(Integer times, AttendanceReward reward) {
        Long amount = reward.getGold();
        String type = reward.getType();
        if (type.equals(ConstantsActivity.DAILY_SIGN)){
            Long addNum = reward.getAddNum();
            amount = amount + (times-1)*addNum;
            if (amount > 50L){
                amount = 50L;
            }
        }
        return amount;
    }


    /**
     * 签到页数据
     * @param cuId
     * @return
     */
    public AttendancePageDto attendcanePage(Long cuId) {
        AttendancePageDto pageDto = new AttendancePageDto();

        //首签日期
        Attendance firstAttendance = attendanceService.getFirstAttendance(cuId);

        //签到日历
        List<AttendanceCalendarDto> calendarDtoList = new ArrayList<>();
        Date now = new Date();
        Date nowDate = null;
        try {
            nowDate = DateFormatUtil.parse(now, DateFormatUtil.FORMAT_SHORT);
        } catch (ParseException e) {
            log.error("日期转换错误：",e);
        }

        int times = 0;
        if (firstAttendance == null){
            //未首签
            times = 0;
            for (int i = 0;i<14; i++){
                Date date = DateFormatUtil.addDay(now, i);
                AttendanceCalendarDto dto = new AttendanceCalendarDto();
                dto.setCompensateStatus(0);
                dto.setStatus(0);
                dto.setDate(DateFormatUtil.formatShort(date));

                calendarDtoList.add(dto);
            }
        }else {
            String firstDateStr = firstAttendance.getAttendanceDate();
            Date firstDate = DateFormatUtil.parseShort(firstDateStr);
            for (int i = -5; i < 14 && calendarDtoList.size() < 14; i++) {
                Date date = DateFormatUtil.addDay(nowDate, i);
                if (DateFormatUtil.compareDate(firstDate,date) <= 0){
                    Integer status = 0;
                    Integer compenstateStatus = 0;
                    String dateStr = DateFormatUtil.formatShort(date);

                    Attendance attendance = attendanceService.getAttendance(cuId,dateStr );
                    AttendanceCalendarDto dto = new AttendanceCalendarDto();

                    if (attendance != null){
                        status = 1;
                    }else {
                        if(DateFormatUtil.compareDate(date,nowDate) < 0){
                            compenstateStatus = 1;
                        }
                    }

                    dto.setDate(dateStr);
                    dto.setStatus(status);
                    dto.setCompensateStatus(compenstateStatus);

                    calendarDtoList.add(dto);
                }
            }


        }
        pageDto.setAttendanceCalendar(calendarDtoList);

        //连续签到次数
        pageDto.setTimes(times);

        //奖励列表
        List<AttendanceRewardDto> rewardDtoList = new ArrayList<>();
        rewardDtoList.addAll(getAttendanceRewardDtoList(ConstantsActivity.FIRST_SIGN));
        rewardDtoList.addAll(getAttendanceRewardDtoList(ConstantsActivity.CONTINUITY_SIGN));

        pageDto.setRewardList(rewardDtoList);


        return pageDto;
    }

    public List<AttendanceRewardDto> getAttendanceRewardDtoList(String type) {
        List<AttendanceRewardDto> rewardDtoList = new ArrayList<>();
        List<AttendanceReward> rewardList = attendanceRewardFacade.listByType(type);
        if (!rewardList.isEmpty()){
            for (AttendanceReward reward: rewardList) {
                AttendanceRewardDto dto = new AttendanceRewardDto();
                BeanUtils.copyProperties(reward,dto);
                rewardDtoList.add(dto);
            }
        }
        return rewardDtoList;
    }

    /**
     * 补签
     * @param cuId
     * @param dateStr
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto compensateSign(Long cuId,String dateStr) {

        Date date = DateFormatUtil.parseShort(dateStr);
        Date now = new Date();
        String nowStr = DateFormatUtil.formatShort(now);
        Date nowDate = DateFormatUtil.parseShort(nowStr);
        //补签日期为今天或晚于今天不能补签
        if (DateFormatUtil.compareDate(date,nowDate) >= 0){
            return ResultDto.errorResult("补签失败");
        }
        //补签日期不能早于今天超过5天
        if(DateFormatUtil.compareDate(date,DateFormatUtil.addDay(nowDate,-5)) < 0){
            return ResultDto.errorResult("补签失败");
        }


        Attendance attendance = attendanceService.getAttendance(cuId, dateStr);
        if (attendance != null){
            return ResultDto.errorResult("补签失败");
        }

        boolean isSign = false;

        attendance = new Attendance();
        attendance.setCuId(cuId);
        attendance.setType(AttendanceTypeEnum.COMPENSATE_SIGN.getCode());
        attendance.setAttendanceDate(dateStr);
        attendance.setCreateTime(new Date());

        Date attendanceDate = DateFormatUtil.parseShort(dateStr);
        Date yesterDay = DateFormatUtil.getYesterdayStartTime(attendanceDate);
        Attendance yesAttendance = attendanceService.getAttendance(cuId, DateFormatUtil.formatShort(yesterDay));
        Integer times = 1;
        if (yesAttendance != null){
            times = yesAttendance.getTimes() + 1;
        }
        attendance.setTimes(times);

        boolean save = attendanceService.save(attendance);
        if(save){
            //修改连续签到次数
            int edTimes = times;
            for(int i=1; true; i++){
                Date day = DateFormatUtil.addDay(attendanceDate, i);
                Attendance attendanceEd = attendanceService.getAttendance(cuId, DateFormatUtil.formatShort(day));
                if(attendanceEd == null){
                    break;
                }
                attendanceEd.setTimes(++edTimes);
                boolean update = attendanceService.updateById(attendanceEd);
                if (!update){
                    throw new BusinessException(ResultEnum.ERROR);
                }
            }
            isSign = true;

        }

        //补签机会消费
        boolean useGold = false;
        long deductGold = 200L;
        if (isSign){
            AttendanceCompensation compensation = compensationService.getByCuid(cuId);
            if (compensation != null && compensation.getTimes() > 0){
                //使用补签机会
                Integer compensationTimes = compensation.getTimes();
                compensation.setTimes(--compensationTimes);
                isSign = compensationService.updateById(compensation);
            }else {
                //金豆补签
                boolean change = customerAccountInfz.attendanceChange(cuId, CurrencyTypeEnum.GOLD, -deductGold, AccountChangeTypeEnum.CONSUME, AccountChangeSpecificTypeEnum.COMPENSATE_ATTENDANCE_DEDUCTION);
                if (!isSign){
                    log.error("扣除金豆失败：cuId:[{}]",cuId);
                }
                isSign = change;
                useGold = true;
            }
        }

        //奖励
        if (!isSign){
            throw new BusinessException(ResultEnum.ERROR);
        }
        Long amount = award(cuId, false, times);
        if (amount == null){
            if (useGold){
                //补签扣款退回
                customerAccountInfz.attendanceChange(cuId, CurrencyTypeEnum.GOLD, deductGold, AccountChangeTypeEnum.CONSUME_RETURN,null);
            }
            ResultEnum resultEnum = ResultEnum.ERROR;
            resultEnum.setMsg("奖励为空");
            throw new BusinessException(resultEnum);
        }

        return ResultDto.succesResult(amount);
    }


    /**
     * 签到状态查询
     * @param cuId
     * @return
     */
    public AttendanceStatusDto signStatus(Long cuId) {
        AttendanceStatusDto dto = new AttendanceStatusDto();
        dto.setMaxAmount(ConstantsActivity.signMaxReward);
        Date now = new Date();
        String dateStr = DateFormatUtil.formatShort(now);
        Attendance attendance = attendanceService.getAttendance(cuId, dateStr);

        String yesterday = DateFormatUtil.getYesterdayShort();
        Attendance yesRecord = attendanceService.getAttendance(cuId,yesterday);
        Integer times = 0;
        if (yesRecord != null){
            Integer yesTimes = yesRecord.getTimes();
            times = ++yesTimes;
        }

        Attendance firstAttendance = attendanceService.getFirstAttendance(cuId);
        
        if (attendance == null){
            //当天未签到
            dto.setStatus(0);
            boolean isFirst = (firstAttendance == null);

            dto.setIsFrist(isFirst?1:0);

            AttendanceReward reward = attendanceRewardFacade.getReward(isFirst, times!=0?times:1);
            if (reward != null){
                if(times < 1){
                    times = 1;
                }
                Long gold = getAmount(times,reward);
                dto.setGoldAmount(gold);
            }


        }else {
            //当天已签到
            times = attendance.getTimes();
            dto.setStatus(1);
            int missedTimes = 0;
            //漏签次数
            String firstDateStr = firstAttendance.getAttendanceDate();
            Date fristDate = DateFormatUtil.parseShort(firstDateStr);

            for (int i = 1; i <= 14; i++) {
                Date date = DateFormatUtil.parseShort(dateStr);
                Date dateTime = DateFormatUtil.subDay(date, i);

                if (DateFormatUtil.compareDate(dateTime,fristDate) <= 0){
                    break;
                }

                Attendance otherAttendance = attendanceService.getAttendance(cuId, DateFormatUtil.formatShort(dateTime));
                if (otherAttendance == null){
                    missedTimes++;
                }
            }
            dto.setTimes(times);
            dto.setMissedTimes(missedTimes);
            //补签后连续次数
            int afterCompensateTimes = times + missedTimes;
            dto.setAfterCompensateTimes(afterCompensateTimes);
        }

        return dto;
    }
}
