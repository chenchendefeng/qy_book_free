package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.OnlineRecord;
import com.only.tech.user.mapper.OnlineRecordMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 上线记录 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-21
 */
@Service
public class OnlineRecordServiceImpl extends ServiceImpl<OnlineRecordMapper, OnlineRecord> implements OnlineRecordService {

}
