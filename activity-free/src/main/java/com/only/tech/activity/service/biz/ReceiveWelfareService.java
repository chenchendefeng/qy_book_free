package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.ReceiveWelfare;
import com.only.tech.enums.WelfareTypeEnum;

import java.util.List;

/**
 * <p>
 * 福利领取记录 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-20
 */
public interface ReceiveWelfareService extends IService<ReceiveWelfare> {

    List<ReceiveWelfare> getByCuidAndTypeAndDate(Long cuId, String type, String dateStr);

    List<ReceiveWelfare> getByCuidAndWefareTypeAndDate(Long cuId, String wefareType, String dateStr);
}
