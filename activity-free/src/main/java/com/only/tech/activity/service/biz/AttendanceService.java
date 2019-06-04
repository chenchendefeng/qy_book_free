package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.Attendance;

/**
 * <p>
 * 签到 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
public interface AttendanceService extends IService<Attendance> {

    boolean signed(Long cuId, String date);

    boolean isFirst(Long cuId);

    Attendance getAttendance(Long cuId, String attendanceDate);

    Attendance getFirstAttendance(Long cuId);
}
