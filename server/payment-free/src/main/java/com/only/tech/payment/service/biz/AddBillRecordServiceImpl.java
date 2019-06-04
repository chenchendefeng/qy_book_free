package com.only.tech.payment.service.biz;

import java.util.List;
import com.only.tech.entity.payment.AddBillRecord;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.payment.common.constant.CommonConstants;
import com.only.tech.payment.mapper.AddBillRecordMapper;

@Service
public class AddBillRecordServiceImpl extends ServiceImpl<AddBillRecordMapper, AddBillRecord>
		implements AddBillRecordService {

	@Override
	public List<AddBillRecord> queryFailRecord() {
		Wrapper<AddBillRecord> wrapper = new QueryWrapper<AddBillRecord>().eq("addBillStatus", CommonConstants.AddBillStatus.FAIL);
		return list(wrapper);
	}

}
