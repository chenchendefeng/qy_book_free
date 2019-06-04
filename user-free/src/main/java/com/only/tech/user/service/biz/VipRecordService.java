package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.VipRecord;

/**
 * 会员记录表 服务类
 * @author shoujun.yang
 * @since 2019-01-04
 */
public interface VipRecordService extends IService<VipRecord> {
	/**
	 * 查询有效的vip
	 * @param uid
	 * @return
	 */
	VipRecord selectVipInfoByUid(Long uid);
	
	void saveOrUpdateByUid(VipRecord vipRecord);

    VipRecord selectByUid(Long uid);
}
