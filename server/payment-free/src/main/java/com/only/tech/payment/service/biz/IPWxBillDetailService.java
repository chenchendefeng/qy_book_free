package com.only.tech.payment.service.biz;

import java.util.Collection;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.payment.PWxBillDetail;

/**
 * <p>
 * 微信账单详情 服务类
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-11-28
 */
public interface IPWxBillDetailService extends IService<PWxBillDetail> {

	List<PWxBillDetail> queryByOutTradeNos(Collection<String> listOrders); 
}
