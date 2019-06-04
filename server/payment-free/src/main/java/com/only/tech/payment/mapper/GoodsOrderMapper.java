package com.only.tech.payment.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.only.tech.entity.payment.GoodsOrder;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 支付订单表
 * @author Lenovo
 *
 */
@Repository
public interface GoodsOrderMapper extends BaseMapper<GoodsOrder>{

	Set<String> queryOutTradeNoAndMoney(@Param(value="startDate")Date startDate,
			@Param(value="endDate")Date endDate,@Param(value="payMethod")Integer payMethod);
	
	List<Map<String, Object>> countOrderByPayMethod(String payDate);
	List<Map<String, Object>> countOrderBySystemType(String payDate);
	BigDecimal sumPayMoneyByPayTime(String date);
}
