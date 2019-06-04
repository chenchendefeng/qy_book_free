package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.CustomerAccount;

/**
 * <p>
 * 用户账户 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-05
 */
public interface CustomerAccountService extends IService<CustomerAccount> {

    CustomerAccount getCuId(Long cuId);
}
