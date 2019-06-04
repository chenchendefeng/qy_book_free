package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.entity.user.CustomerAccount;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.user.mapper.CustomerAccountMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-05
 */
@Service
public class CustomerAccountServiceImpl extends ServiceImpl<CustomerAccountMapper, CustomerAccount> implements CustomerAccountService {

    @Override
    public CustomerAccount getCuId(Long cuId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        return this.getOne(qw);
    }
}
