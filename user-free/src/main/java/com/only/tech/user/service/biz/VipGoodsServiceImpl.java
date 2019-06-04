package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.VipGoods;
import com.only.tech.user.mapper.VipGoodsMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 会员商品表 服务实现类
 * @author shoujun.yang
 * @since 2019-01-04
 */
@Service
public class VipGoodsServiceImpl extends ServiceImpl<VipGoodsMapper, VipGoods> implements VipGoodsService {

	@Autowired
	private VipGoodsMapper vipGoodsMapper;
	
	@Override
	public VipGoods selectByProductId(String productId) {
		Wrapper<VipGoods> wrapper = new QueryWrapper<VipGoods>().eq("productId", productId);
		return super.getOne(wrapper);
	}

	@Override
	public List<VipGoods> getListByStatus(Integer status,String publishedStatus) {
		QueryWrapper<VipGoods> wrapper = new QueryWrapper<VipGoods>();

		if(status !=null){
			wrapper.eq("status", status);
		}

		if(StringUtils.isNotBlank(publishedStatus) ){
			wrapper.eq("publishedStatus", publishedStatus);
		}

		wrapper.orderByAsc("sort").orderByDesc("updateDate");
		return super.list(wrapper);
	}

	@Override
	public VipGoods selectNormalVipGoods() {
		QueryWrapper<VipGoods> wrapper = new QueryWrapper<VipGoods>().eq("type", 1);
		return super.getOne(wrapper);
	}

	@Override
	public void updateGoodsById(VipGoods entity) {
		entity.setUpdateDate(LocalDateTime.now());
		super.updateById(entity);
	}

	@Override
	public void addGoods(VipGoods entity) {
		entity.setCreateDate(LocalDateTime.now());
		entity.setUpdateDate(LocalDateTime.now());
		super.save(entity);
	}

	@Override
	public List<VipGoods> listByStatusChannel(Integer status, String channel) {
		return this.vipGoodsMapper.listByStatusChannel(status, "%" + channel + "%");
	}

	@Override
	public List<VipGoods> selectOnlineGoodsList() {
		return this.vipGoodsMapper.selectOnlineGoodsList();
	}

}
