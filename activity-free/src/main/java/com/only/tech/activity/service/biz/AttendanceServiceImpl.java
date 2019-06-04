package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.AttendanceMapper;
import com.only.tech.entity.activity.Attendance;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 签到 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {


    /**
     * 是否签到
     * @param cuId
     * @param attendanceDate
     * @return
     */
    @Override
    public boolean signed(Long cuId, String attendanceDate) {
        Attendance attendance = this.getAttendance(cuId,attendanceDate);
        return attendance!=null;
    }

    /**
     * 是否是首签
     * @param cuId
     * @return
     */
    @Override
    public boolean isFirst(Long cuId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        int count = this.count(qw);
        return count==0;
    }

    @Override
    public Attendance getAttendance(Long cuId, String attendanceDate) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("attendanceDate",attendanceDate);
        return this.getOne(qw);
    }

    @Override
    public Attendance getFirstAttendance(Long cuId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("type",0);
        return this.getOne(qw);
    }
}
