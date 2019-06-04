package com.only.tech.payment.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.payment.Goods;
import com.only.tech.payment.mapper.GoodsMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类: 商品
 * @author shutong
 * @since 2019/05/14
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

    /**
     * 主键查询
     * @param goodsId
     * @return
     */
    @Override
    public Goods getOneById(Long goodsId) {
        return this.getById(goodsId);
    }

    /**
     * 条件查询商品
     * @param goodsType
     * @param saleStatus
     * @return
     */
    @Override
    public List<Goods> listByCondition(String goodsType, Integer saleStatus) {

        QueryWrapper<Goods> wrapper=new QueryWrapper<Goods>();

        if(StringUtils.isNotBlank(goodsType)){
            wrapper.eq("goodsType",goodsType);
        }

        if(saleStatus!=null){
            wrapper.eq("saleStatus",saleStatus);
        }

        wrapper.orderByAsc("goodsPrice");

        return super.list(wrapper);

    }
}
