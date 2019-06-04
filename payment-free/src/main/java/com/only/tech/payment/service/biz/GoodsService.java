package com.only.tech.payment.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.payment.Goods;
import java.util.List;

/**
 * 服务: 商品
 * @author shutong
 * @since 2019/05/14
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 主键查询
     * @param goodsId
     * @return
     */
    Goods getOneById(Long goodsId);

    /**
     * 条件查询商品
     * @param goodsType
     * @param i
     * @return
     */
    List<Goods> listByCondition(String goodsType, Integer i);
}
