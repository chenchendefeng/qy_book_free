package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerBiz;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Mapper: 用户
 * @author shutong
 * @since 2019/04/30
 */
@Repository
public interface CustomerBizMapper extends BaseMapper<CustomerBiz> {

}
