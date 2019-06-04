package com.only.tech.user.service.biz;

import com.only.tech.entity.user.AccountFlowRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 账户流水 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-05
 */
public interface AccountFlowRecordService extends IService<AccountFlowRecord> {

    /**
     * 查询账户流水（金豆or现金）
     * @param cuId
     * @param currentType
     * @return
     */
    List<AccountFlowRecord> listByCondition(Long cuId, String currentType);
}
