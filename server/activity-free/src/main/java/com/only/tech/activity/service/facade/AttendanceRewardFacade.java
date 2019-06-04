package com.only.tech.activity.service.facade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.activity.common.constants.ConstantsActivity;
import com.only.tech.activity.service.biz.AttendanceRewardService;
import com.only.tech.entity.activity.AttendanceReward;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/9
 */
@Service
public class AttendanceRewardFacade {

    @Autowired
    AttendanceRewardService attendanceRewardService;

    public AttendanceReward getReward(boolean isFirst, Integer times) {
        AttendanceReward reward = null;
        if (isFirst){
            reward = attendanceRewardService.getByType(ConstantsActivity.FIRST_SIGN,null);
        }else {
            if (times == 5 || (times % 10) == 0){
                if (times > 100){
                    times = 100;
                }
                reward = attendanceRewardService.getByType(ConstantsActivity.CONTINUITY_SIGN,times);
            }else {
                reward = attendanceRewardService.getByType(ConstantsActivity.DAILY_SIGN,null);
            }
        }
        return reward;
    }

    public List<AttendanceReward> listByType(String type) {

        QueryWrapper qw = new QueryWrapper();
        if (StringUtils.isNotBlank(type)){
            qw.eq("type",type);
        }
        qw.orderByAsc("days");
        return attendanceRewardService.list(qw);
    }
}
