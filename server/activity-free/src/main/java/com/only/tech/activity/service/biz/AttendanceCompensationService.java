package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.AttendanceCompensation;

/**
 * <p>
 * 补签机会 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
public interface AttendanceCompensationService extends IService<AttendanceCompensation> {

    AttendanceCompensation getByCuid(Long cuId);
}
