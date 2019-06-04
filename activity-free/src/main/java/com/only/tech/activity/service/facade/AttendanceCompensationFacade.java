package com.only.tech.activity.service.facade;

import com.only.tech.activity.service.biz.AttendanceCompensationService;
import com.only.tech.entity.activity.AttendanceCompensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/10
 */
@Service
public class AttendanceCompensationFacade {

    @Autowired
    private AttendanceCompensationService attendanceCompensationService;



    public void addChance(Long cuId) {
        AttendanceCompensation compensation = attendanceCompensationService.getByCuid(cuId);
        if(compensation == null){
            compensation = new AttendanceCompensation();
            compensation.setCuId(cuId);
            compensation.setTimes(1);
            attendanceCompensationService.save(compensation);
        }else {
            Integer times = compensation.getTimes();
            compensation.setTimes(++times);
            attendanceCompensationService.updateById(compensation);
        }
    }
}
