package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.ReadFootprint;
import com.only.tech.user.mapper.ReadFootprintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 阅读足迹 服务实现类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/19
 */
@Service
public class ReadFootprintServiceImpl extends ServiceImpl<ReadFootprintMapper, ReadFootprint> implements ReadFootprintService {

    @Autowired
    private ReadFootprintMapper readFootprintMapper;

    /**
     * 查询用户阅读足迹
     * @param cuId
     * @return
     */
    @Override
    public List<ReadFootprint> listByUid(Long cuId) {
        return readFootprintMapper.getListByUid(cuId);
    }
}
