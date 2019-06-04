package com.only.tech.user.service.biz;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.ReadTimePerday;
import com.only.tech.user.mapper.ReadTimePerdayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类: 用户
 * @author shutong
 * @since 2019/05/08
 */
@Service
public class ReadTimePerdayServiceImpl extends ServiceImpl<ReadTimePerdayMapper, ReadTimePerday> implements ReadTimePerdayService {

    @Autowired
    private ReadTimePerdayMapper readTimePerdayMapper;

    /**
     * 查询用户每日阅读时长
     * @param cuId
     * @param readDate
     * @return
     */
    @Override
    public ReadTimePerday getOneByCondition(Long cuId, String readDate) {
        QueryWrapper<ReadTimePerday> wrapper=new QueryWrapper<ReadTimePerday>();
        wrapper.eq("cuId",cuId);
        wrapper.eq("readDate",readDate);
        return super.getOne(wrapper);
    }

    @Override
    public Integer getReadTime(Long cuId, String date) {
        ReadTimePerday readTimePerday = getOneByCondition(cuId, date);
        if (readTimePerday == null){
            return 0;
        }
        return readTimePerday.getTimeCount();
    }
}
