package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.WelfareChance;
import com.only.tech.enums.WelfareTypeEnum;

/**
 * <p>
 * 福利领取机会 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-20
 */
public interface WelfareChanceService extends IService<WelfareChance> {

    Integer getChanceByCuIdAndType(Long cuId, WelfareTypeEnum turnaroundDraw);

    WelfareChance getByCuidAndType(Long cuId, WelfareTypeEnum turnaroundDraw);
}
