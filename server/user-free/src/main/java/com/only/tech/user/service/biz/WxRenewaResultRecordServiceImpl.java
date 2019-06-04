package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.WxRenewaResultRecord;
import com.only.tech.user.mapper.WxRenewaResultRecordMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信自动续费签约/解约返回结果记录 服务实现类
 * </p>
 *
 * @author ZHI
 * @since 2019-01-17
 */
@Service
public class WxRenewaResultRecordServiceImpl extends ServiceImpl<WxRenewaResultRecordMapper, WxRenewaResultRecord>
		implements WxRenewaResultRecordService {

	@Override
	public WxRenewaResultRecord getByContractCodeChangeType(String contractCode, String changeType) {
		Wrapper<WxRenewaResultRecord> wr = new QueryWrapper<WxRenewaResultRecord>()
				.eq("contractCode", contractCode)
				.eq("changeType", changeType);
		return super.getOne(wr);
	}

}
