package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.AttendanceReward;

/**
 * <p>
 * 签到奖励配置 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
public interface AttendanceRewardService extends IService<AttendanceReward> {

    AttendanceReward getByType(String type, Integer days);
}
