package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.VipGoods;
import java.util.List;

/**
 * <p>
 * 会员商品表 服务类
 * </p>
 *
 * @author shoujun.yang
 * @since 2019-01-04
 */
public interface VipGoodsService extends IService<VipGoods> {

	VipGoods selectByProductId(String productId);

	List<VipGoods> getListByStatus(Integer status, String publishedStatus);
	
	/**
	 * 查询正常vip商品
	 * @return
	 */
	VipGoods selectNormalVipGoods();
	
	void updateGoodsById(VipGoods entity);
	
	void addGoods(VipGoods entity);
	
	/**
	 * 根据状态、渠道号查询上架的列表
	 * @param status
	 * @param channel
	 * @return
	 */
	List<VipGoods> listByStatusChannel(Integer status, String channel);

	/**
	 * 查询上架商品
	 * @return
	 */
	List<VipGoods> selectOnlineGoodsList();
}
