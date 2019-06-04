package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.user.ReadFootprint;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 阅读足迹 Mapper 接口
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/19
 */
@Repository
public interface ReadFootprintMapper extends BaseMapper<ReadFootprint> {

    List<ReadFootprint> getListByUid(Long cuId);

}
