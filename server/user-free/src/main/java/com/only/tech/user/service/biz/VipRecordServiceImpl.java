package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.VipRecord;
import com.only.tech.user.mapper.VipRecordMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 会员记录表 服务实现类
 * @author shoujun.yang
 * @since 2019-01-04
 */
@Service
public class VipRecordServiceImpl extends ServiceImpl<VipRecordMapper, VipRecord> implements VipRecordService {

	@Override
	public VipRecord selectVipInfoByUid(Long uid) {
		Wrapper<VipRecord> wrapper = new QueryWrapper<VipRecord>().eq("uid", uid).ge("vipExpireDate",
				LocalDate.now());
		return super.getOne(wrapper);
	}

	@Override
	public void saveOrUpdateByUid(VipRecord vipRecord) {
		if (vipRecord.getId() != null) {
			vipRecord.setUpdateDate(LocalDateTime.now());
			super.updateById(vipRecord);
		} else {
			vipRecord.setCreateDate(LocalDateTime.now());
			super.save(vipRecord);
		}
	}

	@Override
	public VipRecord selectByUid(Long uid) {
		Wrapper<VipRecord> qw = new QueryWrapper<VipRecord>().eq("uid", uid);
		return this.getOne(qw);
	}

}
