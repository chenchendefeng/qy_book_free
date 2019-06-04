package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.AutoRenewa;
import com.only.tech.user.mapper.AutoRenewaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 自动续费 服务实现类
 * </p>
 *
 * @author ZHI
 * @since 2019-01-15
 */
@Service
public class AutoRenewaServiceImpl extends ServiceImpl<AutoRenewaMapper, AutoRenewa> implements AutoRenewaService {


    @Autowired
    private AutoRenewaMapper autoRenewaMapper;

    @Override
    public List<Long> statisticalExpireUid(String date) {

        return autoRenewaMapper.statisticalExpireUid(date);
    }
}
