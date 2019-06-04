package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.ExtraBonusMapper;
import com.only.tech.entity.activity.ExtraBonus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 额外奖励 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-17
 */
@Service
public class ExtraBonusServiceImpl extends ServiceImpl<ExtraBonusMapper, ExtraBonus> implements ExtraBonusService {

    @Override
    public ExtraBonus getByCuidAndStatus(Long cuId, Integer status) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("status",status);
        return getOne(qw);
    }


    @Override
    public List<ExtraBonus> listByDate(Date date) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("status",0);
        qw.le("expiryTime",date);
        return list(qw);
    }
}
