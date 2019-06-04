package com.only.tech.entity.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类：横幅广告轮播图
 * 
 * @author HUA MAN LOU
 * @date 2019/4/30
 * @version 1.0
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Banner implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 图片URL
	 */
	private String img;

	/**
	 * 链接地址
	 */
	private String url;

	/**
	 * 位置(recommend推荐、girl女生、boy男生、personalCenter个人中心、categoryBoy分类-男生、categoryGirl分类-女生)
	 */
	private String position;

	/**
	 * banner对象类型（H5、App）
	 */
	private String type;

	/**
	 * 关联id,code等
	 */
	private String associatedId;

	/**
	 * 轮播图开始时间
	 */
	private Date beginTime;

	/**
	 * 轮播图结束时间
	 */
	private Date endTime;

	/**
	 * 有效状态 1：有效；0；无效
	 */
	private Integer validStatus;

	/**
	 * 渠道
	 */
	private String channel;

	/**
	 * 排序
	 */
	private Integer orderIndex;

	/**
	 * 背景色
	 */
	private String bgColor;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

}
