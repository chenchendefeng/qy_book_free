package com.only.tech.activity.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.activity.service.biz.WelfareChanceService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultEnum;
import com.only.tech.constant.ActivityConstants;
import com.only.tech.entity.activity.WelfareChance;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.enums.WelfareTypeEnum;
import com.only.tech.exposeinfz.user.api.CustomerAccountInfz;
import ooh.chaos.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/20
 */
@Service
public class TurnaroundDrawFacade {

    @Autowired
    private WelfareChanceService welfareChanceService;

    @Reference
    private CustomerAccountInfz customerAccountInfz;


    public Integer getChance(Long cuId) {
        return welfareChanceService.getChanceByCuIdAndType(cuId, WelfareTypeEnum.TURNAROUND_DRAW);
    }

    public ResultDto addChance(Long cuId) {
        WelfareChance welfareChance = welfareChanceService.getByCuidAndType(cuId,WelfareTypeEnum.TURNAROUND_DRAW);
        Integer restTimes = welfareChance.getRestTimes();
        if (restTimes >= 5){
            return ResultDto.errorResult("每天最多5次机会");
        }
        welfareChance.setRestTimes(++restTimes);
        welfareChanceService.updateById(welfareChance);
        return ResultDto.succesResult("添加成功");
    }

    public ResultDto draw(Long cuId) {
        WelfareChance welfareChance = welfareChanceService.getByCuidAndType(cuId, WelfareTypeEnum.TURNAROUND_DRAW);
        Integer restTimes = welfareChance.getRestTimes();
        Integer usedTimes = welfareChance.getUsedTimes();
        if (restTimes-usedTimes > 0){
            //修改使用次数
            welfareChance.setUsedTimes(++usedTimes);
            boolean update = welfareChanceService.updateById(welfareChance);

            if (update) {
                //奖励
                boolean change = customerAccountInfz.attendanceChange(cuId, CurrencyTypeEnum.GOLD, ActivityConstants.TURNAROUND_AWARD_50, AccountChangeTypeEnum.REWARD, AccountChangeSpecificTypeEnum.DRAW_LUCKY_TURNTABLE_AWARD);
                if (change){
                    return ResultDto.succesResult(ActivityConstants.TURNAROUND_AWARD_50);
                }else {
                    ResultEnum resultEnum = ResultEnum.ERROR;
                    resultEnum.setMsg("奖励失败");
                    throw new BusinessException(resultEnum);
                }
            }
        }

        return ResultDto.errorResult("没有抽奖机会");
    }
}
