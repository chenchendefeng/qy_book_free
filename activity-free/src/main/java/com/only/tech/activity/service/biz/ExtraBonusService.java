package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.ExtraBonus;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 额外奖励 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-17
 */
public interface ExtraBonusService extends IService<ExtraBonus> {

    ExtraBonus getByCuidAndStatus(Long cuId, Integer status);

    List<ExtraBonus> listByDate(Date date);
}
