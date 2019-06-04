package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.CompensateChanceReceive;

/**
 * <p>
 * 补签机会领取记录 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
public interface CompensateChanceReceiveService extends IService<CompensateChanceReceive> {

    CompensateChanceReceive getRecord(Long cuId, String type, String nowStr);
}
