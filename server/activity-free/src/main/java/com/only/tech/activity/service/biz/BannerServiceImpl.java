package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.BannerMapper;
import com.only.tech.dto.activity.BannerReqDto;
import com.only.tech.entity.activity.Banner;
import com.only.tech.enums.PageEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 业务接口实现类：横幅广告轮播图
 *
 * @author HUA MAN LOU
 * @date 2019/4/29
 * @version 1.0
 */
@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService{

    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 根据条件查询轮播图列表
     */
    @Override
    public List<Banner> selectByCondition(BannerReqDto dto) {
        return bannerMapper.selectByCondition(dto);
    }

    /**
     * 根据状态和渠道查询banner
     * @param status
     * @param channelCode
     * @return
     */
    @Override
    public List<Banner> listByStatusAndChannelCode(String status, String channelCode) {

        QueryWrapper<Banner> wrapper = new QueryWrapper<Banner>();

        if (StringUtils.isNotBlank(status) && !"all".equalsIgnoreCase(status)) {
            wrapper.eq("validStatus", status);
        }

        if(StringUtils.isNotBlank(channelCode) && !"all".equalsIgnoreCase(channelCode)){
            wrapper.like("channel",channelCode);
        }

        return super.list(wrapper);

    }

    @Override
    public List<Banner> selectByConditionAndChannel(PageEnum pageEnum, String channel) {
        QueryWrapper<Banner> qw = new QueryWrapper<>();
        if (pageEnum != null){
            qw.eq("position",pageEnum.getPage());
        }
        if (StringUtils.isNotBlank(channel)){
            qw.eq("channel",channel);
        }
        qw.eq("validStatus",1);
        Date now = new Date();
        qw.le("beginTime",now);
        qw.ge("endTime",now);

        return this.list(qw);
    }

}
