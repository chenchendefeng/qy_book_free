package com.only.tech.admin.service.biz;

import com.only.tech.admin.mapper.ALogMapper;
import com.only.tech.admin.service.biz.IALogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.admin.ALog;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-12-10
 */
@Service
public class ALogServiceImpl extends ServiceImpl<ALogMapper, ALog> implements IALogService {

}
