package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.user.AutoRenewa;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 自动续费 Mapper 接口
 * </p>
 *
 * @author ZHI
 * @since 2019-01-15
 */
@Repository
public interface AutoRenewaMapper extends BaseMapper<AutoRenewa> {

    List<Long> statisticalExpireUid(String date);
}
