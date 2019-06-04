package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.PayRecord;
import java.util.List;

/**
 * 支付记录表 服务类
 * @author shoujun.yang
 * @since 2018-12-19
 */
public interface PayRecordService extends IService<PayRecord> {

	public PayRecord queryByPayOrderNo(String payOrderNo);

	public void saveByOrderNo(Long uid, String payOrderNo, Long readCardId, Long vipId, Integer orderMoney,String systemType);

	public void saveOrUpdateByOrderNo(Long uid, String payOrderNo, Long readCardId, Long vipId, Integer orderMoney, String systemType);

	public int countPayByUidAndPayDate(Long uid, String payDate);


	/**
	 * 查询订单号是否已经被用过
	 * 
	 * @param outTradeNo
	 * @return
	 */
	boolean isOutTradeNoUsed(String outTradeNo);
}
