package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.dto.user.UVipGoodsDto;
import com.only.tech.entity.user.VipGoods;
import com.only.tech.exposeinfz.user.api.UserVipInfz;
import com.only.tech.user.service.biz.VipGoodsService;
import com.only.tech.user.service.facade.UserVipFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service(interfaceClass = UserVipInfz.class)
@Component
public class UserVipInfzImpl implements UserVipInfz {

	@Autowired
	VipGoodsService vipGoodsService;

	@Autowired
	UserVipFacade userVipFacade;



	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean userBuyVip(Long uid, Long vipId, String payOrderNo, String systemType) {
		try {
			return userVipFacade.buyVip(uid,vipId,payOrderNo,systemType);
		} catch (Exception e) {
			log.error("UserVipInfz.userBuyVip error ,vipId={},payOrderNo={},uid={}", vipId, payOrderNo, uid, e);
		}
		return false;
	}

	@Override
	public UVipGoodsDto selectByVipId(Long vipId) {
		VipGoods vipGoods = this.vipGoodsService.getById(vipId);
		if (vipGoods != null) {
			UVipGoodsDto goodsDto = new UVipGoodsDto();
			BeanUtils.copyProperties(vipGoods, goodsDto);
			return goodsDto;
		}
		return null;
	}

	@Override
	public UVipGoodsDto selectNormalVipGoods() {
		VipGoods vipGoods = this.vipGoodsService.selectNormalVipGoods();
		if (vipGoods != null) {
			UVipGoodsDto goodsDto = new UVipGoodsDto();
			BeanUtils.copyProperties(vipGoods, goodsDto);
			return goodsDto;
		}
		return null;
	}

	@Override
	public List<UVipGoodsDto> selectByStatus(Integer status,String publishedStatus) {
		List<VipGoods> goodsList = this.vipGoodsService.getListByStatus(status,publishedStatus);
		List<UVipGoodsDto> dtoList = new ArrayList<UVipGoodsDto>();
		goodsList.forEach(i -> {
			UVipGoodsDto dto = new UVipGoodsDto();
			BeanUtils.copyProperties(i, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}


	@Override
	public void deleteById(Long id) {
		vipGoodsService.removeById(id);
	}

	@Override
	public void saveOrUpdate(UVipGoodsDto dto) {
		VipGoods vipGoods = new VipGoods();
		BeanUtils.copyProperties(dto, vipGoods);
		vipGoodsService.saveOrUpdate(vipGoods);
	}

	@Override
	public UVipGoodsDto selectByProductId(String productId) {
		VipGoods vipGoods=this.vipGoodsService.selectByProductId(productId);
		if(vipGoods!=null){
			UVipGoodsDto dto=new UVipGoodsDto();
			BeanUtils.copyProperties(vipGoods,dto);
			return dto;
		}else{
			return null;
		}
	}
}
