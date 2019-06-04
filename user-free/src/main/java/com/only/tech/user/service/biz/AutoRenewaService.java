package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.AutoRenewa;


import java.util.List;

/**
 * <p>
 * 自动续费 服务类
 * </p>
 *
 * @author ZHI
 * @since 2019-01-15
 */
public interface AutoRenewaService extends IService<AutoRenewa> {

    List<Long> statisticalExpireUid(String date);
}
