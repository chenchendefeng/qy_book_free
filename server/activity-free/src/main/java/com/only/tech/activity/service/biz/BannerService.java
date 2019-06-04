package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.activity.BannerReqDto;
import com.only.tech.entity.activity.Banner;
import com.only.tech.enums.PageEnum;

import java.util.List;

/**
 * 业务接口：横幅广告轮播图
 * 
 * @author HUA MAN LOU
 * @date 2019/4/30
 * @version 1.0
 */
public interface BannerService extends IService<Banner> {

	/**
	 * 根据条件查询轮播图列表
	 * 
	 * @param dto
	 * @return
	 */
	List<Banner> selectByCondition(BannerReqDto dto);

	/**
	 * 根据状态和渠道查询banner
	 * @param status
	 * @param channelCode
	 * @return
	 */
	List<Banner> listByStatusAndChannelCode(String status, String channelCode);

	List<Banner> selectByConditionAndChannel(PageEnum pageEnum, String channel);
}
