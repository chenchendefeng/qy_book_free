package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.ReceiveWelfareMapper;
import com.only.tech.entity.activity.ReceiveWelfare;
import com.only.tech.enums.WelfareTypeEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 福利领取记录 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-20
 */
@Service
public class ReceiveWelfareServiceImpl extends ServiceImpl<ReceiveWelfareMapper, ReceiveWelfare> implements ReceiveWelfareService {

    @Override
    public List<ReceiveWelfare> getByCuidAndTypeAndDate(Long cuId, String type, String dateStr) {
        QueryWrapper qw = new QueryWrapper();
        if (cuId != null) {
            qw.eq("cuId",cuId);
        }
        if (StringUtils.isNotBlank(type)){
            qw.eq("type",type);
        }
        if (StringUtils.isNotBlank(dateStr)){
            qw.eq("date",dateStr);
        }

        return this.list(qw);
    }

    @Override
    public List<ReceiveWelfare> getByCuidAndWefareTypeAndDate(Long cuId, String wefareType, String dateStr) {
        QueryWrapper qw = new QueryWrapper();
        if (cuId != null) {
            qw.eq("cuId",cuId);
        }
        if (StringUtils.isNotBlank(wefareType)){
            qw.eq("welfareType",wefareType);
        }
        if (StringUtils.isNotBlank(dateStr)){
            qw.eq("date",dateStr);
        }

        return this.list(qw);
    }
}
