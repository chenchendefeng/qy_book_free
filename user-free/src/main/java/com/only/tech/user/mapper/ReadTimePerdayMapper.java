package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.ReadTimePerday;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Mapper: 用户阅读时长
 * @author shutong
 * @since 2019/05/08
 */
@Repository
public interface ReadTimePerdayMapper extends BaseMapper<ReadTimePerday> {


}
