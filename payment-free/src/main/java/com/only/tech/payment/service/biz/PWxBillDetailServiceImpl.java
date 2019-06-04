package com.only.tech.payment.service.biz;

import java.util.Collection;
import java.util.List;
import com.only.tech.entity.payment.PWxBillDetail;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.payment.mapper.PWxBillDetailMapper;

/**
 * <p>
 * 微信账单详情 服务实现类
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-11-28
 */
@Service
public class PWxBillDetailServiceImpl extends ServiceImpl<PWxBillDetailMapper, PWxBillDetail> implements IPWxBillDetailService {

	@Override
	public List<PWxBillDetail> queryByOutTradeNos(Collection<String> listOrders) {
		Wrapper<PWxBillDetail> wrapper = new QueryWrapper<PWxBillDetail>().in("outTradeNo", listOrders);
		return super.list(wrapper);
	}

}
