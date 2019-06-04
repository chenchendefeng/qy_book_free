package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.SystemConfig;
import com.only.tech.user.mapper.SystemConfigMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-23
 */
@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Override
    public SystemConfig getBype(String type) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("type",type);
        return this.getOne(qw);
    }
}
