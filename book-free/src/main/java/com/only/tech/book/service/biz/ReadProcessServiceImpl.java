package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.book.mapper.ReadProcessMapper;
import com.only.tech.entity.book.ReadProcess;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书籍阅读进度表 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-08
 */
@Service
public class ReadProcessServiceImpl extends ServiceImpl<ReadProcessMapper, ReadProcess> implements ReadProcessService {

    @Override
    public ReadProcess getByCuidAndBid(Long cuId, Long bid) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("bid",bid);
        return this.getOne(qw);
    }
}
