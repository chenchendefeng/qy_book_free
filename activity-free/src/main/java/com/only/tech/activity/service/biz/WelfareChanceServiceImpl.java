package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.WelfareChanceMapper;
import com.only.tech.entity.activity.WelfareChance;
import com.only.tech.enums.WelfareTypeEnum;
import ooh.chaos.util.DateFormatUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 福利领取机会 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-20
 */
@Service
public class WelfareChanceServiceImpl extends ServiceImpl<WelfareChanceMapper, WelfareChance> implements WelfareChanceService {

    @Override
    public Integer getChanceByCuIdAndType(Long cuId, WelfareTypeEnum typeEnum) {
        WelfareChance welfareChance = this.getByCuidAndType(cuId, typeEnum);
        return welfareChance.getRestTimes()-welfareChance.getUsedTimes();
    }

    @Override
    public WelfareChance getByCuidAndType(Long cuId, WelfareTypeEnum typeEnum) {
        Date now = new Date();
        String dateStr = DateFormatUtil.formatShort(now);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("type",typeEnum.getType());
        qw.eq("date",dateStr);
        WelfareChance welfareChance = this.getOne(qw);
        if (welfareChance == null){
            welfareChance = new WelfareChance();
            welfareChance.setCuId(cuId);
            welfareChance.setType(typeEnum.getType());
            welfareChance.setDate(DateFormatUtil.parseShort(dateStr));
            welfareChance.setRestTimes(1);
            welfareChance.setUsedTimes(0);
            this.save(welfareChance);
        }

        return welfareChance;
    }
}
