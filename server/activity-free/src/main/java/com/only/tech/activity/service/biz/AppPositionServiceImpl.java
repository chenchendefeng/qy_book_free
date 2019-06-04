package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.AppPositionMapper;
import com.only.tech.entity.activity.AppPosition;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 服务实现：app页面位置
 * @author shutong
 * @since 2019/03/10
 */
@Service
public class AppPositionServiceImpl extends ServiceImpl<AppPositionMapper, AppPosition> implements AppPositionService {

    /**
     * 根据位置编码查询位置
     * @param positionCode
     * @return
     */
    @Override
    public AppPosition getOneByCode(String positionCode) {
        QueryWrapper<AppPosition> wrapper=new QueryWrapper<AppPosition>();
        wrapper.eq("positionCode",positionCode);
        return super.getOne(wrapper);
    }

    @Override
    public List<AppPosition> listAll() {
        QueryWrapper<AppPosition> wrapper=new QueryWrapper<AppPosition>();
        wrapper.orderByDesc("id");
        return super.list(wrapper);
    }
}
