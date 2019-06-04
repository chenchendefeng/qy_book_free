package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.WxRenewaResultRecord;


/**
 * <p>
 * 微信自动续费签约/解约返回结果记录 服务类
 * </p>
 *
 * @author ZHI
 * @since 2019-01-17
 */
public interface WxRenewaResultRecordService extends IService<WxRenewaResultRecord> {
	
	WxRenewaResultRecord getByContractCodeChangeType(String contractCode, String changeType);
}
