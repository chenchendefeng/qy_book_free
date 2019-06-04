package com.only.tech.payment.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.exposeinfz.payment.api.GoodsInfz;
import com.only.tech.exposeinfz.payment.api.GoodsOrderInfz;
import com.only.tech.payment.service.biz.GoodsOrderService;
import com.only.tech.payment.service.biz.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 接口实现类：订单
 * @author shutong
 * @since 2019/05/20
 */
@Slf4j
@Service(interfaceClass = GoodsOrderInfz.class)
@Component
public class GoodsOrderInfzImpl implements GoodsOrderInfz {

	@Autowired
	private GoodsOrderService orderService;


    /**
     * 分页查询订单
     * @param pageReq
     * @param createDateStart
     * @param createDateEnd
     * @param cuId
     * @param paymentStatus
     * @return
     */
    @Override
    public PageData<GoodsOrder> pageListByCondition(PageReq pageReq, String createDateStart, String createDateEnd, Long cuId, Integer paymentStatus) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        List<GoodsOrder> goodsList = this.orderService.listByCondition(createDateStart,createDateEnd,cuId,paymentStatus);
        PageData pageData = new PageData(page);
        pageData.setData(goodsList);

        return pageData;
    }


}
