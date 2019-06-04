package com.only.tech.exposeinfz.user.api;

import com.only.tech.dto.user.UVipGoodsDto;
import java.util.List;

public interface UserVipInfz {

	/**
	 * 用户购买会员
	 * @param uid
	 * @param vipId
	 * @param payOrderNo
	 * @param systemType
	 * @return
	 */
	boolean userBuyVip(Long uid, Long vipId, String payOrderNo, String systemType);

	/**
	 * 根据会员卡id查询
	 * 
	 * @param vipId
	 * @return
	 */
	UVipGoodsDto selectByVipId(Long vipId);

	/**
	 * 查询普通vip商品的价格
	 * 
	 * @return
	 */
	UVipGoodsDto selectNormalVipGoods();

	/**
	 * 根据状态查询列表
	 * 
	 * @param status
	 * @return
	 */
	List<UVipGoodsDto> selectByStatus(Integer status, String publishedStatus);


	/**
	 * 删除
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 修改或者保存
	 * @param dto
	 */
	void saveOrUpdate(UVipGoodsDto dto);

	/**
	 * 根据商品ID查询会员商品
	 * @param productId
	 * @return
	 */
	UVipGoodsDto selectByProductId(String productId);
}
