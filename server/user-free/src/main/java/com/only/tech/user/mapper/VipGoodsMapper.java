package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.user.VipGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员商品表 Mapper 接口
 * @author shoujun.yang
 * @since 2019-01-04
 */
@Repository
public interface VipGoodsMapper extends BaseMapper<VipGoods> {

	public List<VipGoods> listByStatusChannel(@Param(value = "status") Integer status,
											  @Param(value = "channel") String channel);

	/**
	 * 查询上线商品
	 * @return
	 */
    List<VipGoods> selectOnlineGoodsList();
}
