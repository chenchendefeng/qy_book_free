package com.only.tech.activity.service.facade;

import com.only.tech.activity.service.biz.CompensateChanceReceiveService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.activity.AttendanceCompensation;
import com.only.tech.entity.activity.CompensateChanceReceive;
import ooh.chaos.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/10
 */
@Service
public class CompensateChanceReceiveFacade {

    @Autowired
    private CompensateChanceReceiveService compensateChanceReceiveService;

    @Autowired
    private AttendanceCompensationFacade attendanceCompensationFacade;

    public ResultDto receive(Long cuId, String type) {
        Date now = new Date();
        String nowStr = DateFormatUtil.formatShort(now);

        CompensateChanceReceive compensateChanceReceive = compensateChanceReceiveService.getRecord(cuId,type,nowStr);
        if (compensateChanceReceive != null){
            return ResultDto.errorResult("重复领取");
        }
        compensateChanceReceive = new CompensateChanceReceive();
        compensateChanceReceive.setCuId(cuId);
        compensateChanceReceive.setType(type);
        compensateChanceReceive.setReceiveDate(nowStr);
        compensateChanceReceive.setCreateTime(now);
        boolean save = compensateChanceReceiveService.save(compensateChanceReceive);

        if (save){
            attendanceCompensationFacade.addChance(cuId);
        }


        return save?ResultDto.succesResult("领取成功"):ResultDto.errorResult("领取失败");
    }
}
