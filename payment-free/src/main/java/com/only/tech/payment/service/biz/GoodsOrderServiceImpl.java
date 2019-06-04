package com.only.tech.payment.service.biz;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.payment.common.utils.DateUtils;
import com.only.tech.payment.common.constant.AliPayConfigConstants;
import com.only.tech.payment.mapper.GoodsOrderMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderMapper, GoodsOrder>
		implements GoodsOrderService {

	@Autowired
	private GoodsOrderMapper goodsOrderMapper;
	@Override
	public void updateOrderByOrderNum(GoodsOrder order) {
		Wrapper<GoodsOrder> wrapper = new UpdateWrapper<GoodsOrder>().eq("orderNum", order.getOrderNum());
		super.update(order, wrapper);
	}

	@Override
	public GoodsOrder queryOrderByOutTradeNo(String orderNo) {
		Wrapper<GoodsOrder> wrapper = new QueryWrapper<GoodsOrder>().eq("order_num", orderNo);
		return super.getOne(wrapper,false);
	}

	@Override
	public Set<String> queryOutTradeNoAndMoney(String billDate,Integer payMethod) {
		try{
			if(payMethod == AliPayConfigConstants.PAY_METHOD_AL)
			{
				String[] dateArray = billDate.split("-");
				if(dateArray.length == 2)
				{//月账单 2018-11
					Date startDate = DateUtils.timeStrToDate(billDate, "yyyy-MM");
					String lastDay = DateUtils.getLastDayOfMonth(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]));
					String endStr = lastDay + " 23:59:59";
					Date endDate = DateUtils.timeStrToDate(endStr, null);
					return goodsOrderMapper.queryOutTradeNoAndMoney(startDate, endDate ,payMethod);
				}
				else if(dateArray.length == 3)
				{//日账单 2018-11-11
					Date startDate = DateUtils.timeStrToDate(billDate, "yyyy-MM-dd");
					String endStr = billDate + " 23:59:59";
					Date endDate = DateUtils.timeStrToDate(endStr, null);
					return goodsOrderMapper.queryOutTradeNoAndMoney(startDate, endDate ,payMethod);
				}
			}
			else
			{//微信对账单日期格式是20181111
				Date startDate = DateUtils.timeStrToDate(billDate, "yyyyMMdd");
				String endStr = billDate + " 23:59:59";
				Date endDate = DateUtils.timeStrToDate(endStr, "yyyyMMdd HH:mm:ss");
				return goodsOrderMapper.queryOutTradeNoAndMoney(startDate, endDate ,payMethod);
			}
		}
		catch(ParseException e)
		{
			log.error("queryOutTradeNoAndMoney parse billDate error,billDate={},payMethod={}",billDate,payMethod,e);
		}
		return null;
	}

	/**
	 * 条件查询订单
	 * @param createDateStartStr
	 * @param createDateEndStr
	 * @param cuId
	 * @param paymentStatus
	 * @return
	 */
    @Override
    public List<GoodsOrder> listByCondition(String createDateStartStr, String createDateEndStr, Long cuId, Integer paymentStatus) {

    	QueryWrapper<GoodsOrder> wrapper=new QueryWrapper<GoodsOrder>();

    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	if(StringUtils.isNotBlank(createDateStartStr)){
			try {
				Date createDateStart = sdf.parse(createDateStartStr+" 00:00:00");
				wrapper.ge("createDate",createDateStart);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if(StringUtils.isNotBlank(createDateEndStr)){
			try {
				Date createDateEnd = sdf.parse(createDateEndStr+" 23:59:59");
				wrapper.le("createDate",createDateEnd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if(cuId!=null){
			wrapper.eq("cuId",cuId);
		}

		if(paymentStatus!=null){
			wrapper.eq("paymentStatus",paymentStatus);
		}

        return super.list(wrapper);
    }

}
