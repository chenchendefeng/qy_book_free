package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.SystemConfig;

/**
 * <p>
 * 系统配置 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-23
 */
public interface SystemConfigService extends IService<SystemConfig> {

    SystemConfig getBype(String exchangeRatio);
}
