package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.AttendanceRewardMapper;
import com.only.tech.entity.activity.AttendanceReward;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 签到奖励配置 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Service
public class AttendanceRewardServiceImpl extends ServiceImpl<AttendanceRewardMapper, AttendanceReward> implements AttendanceRewardService {

    @Override
    public AttendanceReward getByType(String type, Integer days) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("type",type);
        if (days != null){
            qw.eq("days",days);
        }
        return this.getOne(qw);
    }
}
