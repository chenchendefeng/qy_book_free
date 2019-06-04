package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.exposeinfz.activity.dto.RespDto;
import com.only.tech.exposeinfz.payment.api.GoodsInfz;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 商品
 * @author shutong
 * @since 2019/05/15
 */
@Service
public class GoodsFacade {

	@Reference
	private GoodsInfz goodsInfz;

	/**
	 * 分页查询商品列表（ 会员| ...）
	 * @param pageReq
	 * @param goodsType
	 * @param saleStatus
	 * @return
	 */
	public PageData<Goods> pageListByCondition(PageReq pageReq, String goodsType, Integer saleStatus) {
		return this.goodsInfz.pageListByCondition(pageReq,goodsType,saleStatus);
	}

	/**
	 * 新增or修改
	 * @param goodsDto
	 * @return
	 */
	public void saveOrUpdate(GoodsDto goodsDto) {
		this.goodsInfz.saveOrUpdate(goodsDto);
	}

	/**
	 * 查询商品信息
	 * @param id
	 * @return
	 */
    public Goods getOneById(Long id) {

    	return this.goodsInfz.getOneById(id);
    }
}
