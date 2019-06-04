package com.only.tech.payment.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookSubject;
import com.only.tech.entity.payment.Goods;
import com.only.tech.exposeinfz.activity.dto.RespDto;
import com.only.tech.exposeinfz.payment.api.GoodsInfz;
import com.only.tech.payment.service.biz.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 接口实现类：商品
 * @author shutong
 * @since 2019/05/15
 */
@Slf4j
@Service(interfaceClass = GoodsInfz.class)
@Component
public class GoodsInfzImpl implements GoodsInfz {

	@Autowired
	private GoodsService goodsService;


    /**
     * 分页查询商品列表（ 会员| ...）
     * @param pageReq
     * @param goodsType
     * @param saleStatus
     * @return
     */
    @Override
    public PageData<Goods> pageListByCondition(PageReq pageReq, String goodsType, Integer saleStatus) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        List<Goods> goodsList = this.goodsService.listByCondition(goodsType,saleStatus);
        PageData pageData = new PageData(page);
        pageData.setData(goodsList);

        return pageData;
    }


    /**
     * 新增or修改
     * @param goodsDto
     * @return
     */
    @Override
    public void saveOrUpdate(GoodsDto goodsDto) {

        Goods goods=new Goods();
        BeanUtils.copyProperties(goodsDto,goods);

        if(goods.getId()==null){
            goods.setCreateTime(new Date());
            goods.setGoodsCode(goods.getGoodsType()+System.currentTimeMillis());
        }
        this.goodsService.saveOrUpdate(goods);
    }

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    @Override
    public Goods getOneById(Long id) {
        return this.goodsService.getOneById(id);
    }
}
