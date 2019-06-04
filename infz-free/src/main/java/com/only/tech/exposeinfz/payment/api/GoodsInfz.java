package com.only.tech.exposeinfz.payment.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.exposeinfz.activity.dto.RespDto;

/**
 * infz: 商品（会员 | ...）
 * @author shutong
 * @since 2019/05/15
 */
public interface GoodsInfz {

    /**
     * 分页查询商品列表（ 会员| ...）
     * @param pageReq
     * @param goodsType
     * @param saleStatus
     * @return
     */
    PageData<Goods> pageListByCondition(PageReq pageReq, String goodsType, Integer saleStatus);

    /**
     * 新增or修改
     * @param goodsDto
     * @return
     */
    void saveOrUpdate(GoodsDto goodsDto);

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    Goods getOneById(Long id);
}
