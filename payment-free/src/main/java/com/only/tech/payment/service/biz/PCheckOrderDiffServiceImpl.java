package com.only.tech.payment.service.biz;

import com.only.tech.entity.payment.PCheckOrderDiff;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.payment.mapper.PCheckOrderDiffMapper;

/**
 * <p>
 * 对账异常记录表 服务实现类
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-11-27
 */
@Service
public class PCheckOrderDiffServiceImpl extends ServiceImpl<PCheckOrderDiffMapper, PCheckOrderDiff> implements IPCheckOrderDiffService {

}
