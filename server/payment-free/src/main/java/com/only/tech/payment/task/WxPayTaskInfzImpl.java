package com.only.tech.payment.task;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.exposeinfz.payment.task.WxPayTaskInfz;
import com.only.tech.payment.common.utils.DateUtils;
import com.only.tech.payment.service.facade.WeiXinPayFacade;
import com.only.tech.payment.service.facade.WeixinBillFacade;
import lombok.extern.slf4j.Slf4j;

@Service(interfaceClass = WxPayTaskInfz.class)
@Slf4j
@Component
public class WxPayTaskInfzImpl implements WxPayTaskInfz{
	
	@Autowired
	private WeiXinPayFacade weiXinPayFacade;
	@Autowired
	private WeixinBillFacade weixinBillFacade;
	
	@Override
	public void execute() {
		log.info("begin execute query order task");
		weiXinPayFacade.executeQuery(null);
		log.info("end execute query order task");
	}
	
	@Override
	public void executeCheckBill(String param) {
		if(StringUtils.isEmpty(param))
		{//今天的前一天
			param = DateUtils.dateToStr(DateUtils.getPreDay(new Date(), 1), "yyyyMMdd");
		}
		weixinBillFacade.executeCheckWeiXinBill(param);
	}
}
