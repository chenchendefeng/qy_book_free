package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.AttendanceCompensationMapper;
import com.only.tech.entity.activity.AttendanceCompensation;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 补签机会 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Service
public class AttendanceCompensationServiceImpl extends ServiceImpl<AttendanceCompensationMapper, AttendanceCompensation> implements AttendanceCompensationService {

    @Override
    public AttendanceCompensation getByCuid(Long cuId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        return this.getOne(qw);
    }
}
