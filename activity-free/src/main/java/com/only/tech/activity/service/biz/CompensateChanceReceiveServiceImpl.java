package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.entity.activity.CompensateChanceReceive;
import com.only.tech.activity.mapper.CompensateChanceReceiveMapper;
import com.only.tech.activity.service.biz.CompensateChanceReceiveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 补签机会领取记录 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
@Service
public class CompensateChanceReceiveServiceImpl extends ServiceImpl<CompensateChanceReceiveMapper, CompensateChanceReceive> implements CompensateChanceReceiveService {

    @Override
    public CompensateChanceReceive getRecord(Long cuId, String type, String receiveDate) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("type",type);
        qw.eq("receiveDate",receiveDate);
        return this.getOne(qw);
    }
}
