package com.only.tech.payment.service.biz;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.payment.AddBillRecord;

/**
 * 充值金额配置服务类
 * @author Lenovo
 *
 */
public interface AddBillRecordService extends IService<AddBillRecord> {
	List<AddBillRecord> queryFailRecord();
}
