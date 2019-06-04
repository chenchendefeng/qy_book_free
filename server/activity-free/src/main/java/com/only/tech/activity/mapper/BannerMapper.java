package com.only.tech.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.activity.BannerReqDto;
import com.only.tech.entity.activity.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据接口层：横幅广告轮播图
 *
 * @author HUA MAN LOU
 * @date 2019/4/29
 * @version 1.0
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    /**selectByCondition
     * 根据条件查询轮播图列表
     *
     * @param dto
     * @return
     */
    List<Banner> selectByCondition(BannerReqDto dto);
}
