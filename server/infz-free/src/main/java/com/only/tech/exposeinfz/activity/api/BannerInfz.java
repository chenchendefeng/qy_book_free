package com.only.tech.exposeinfz.activity.api;

import com.only.tech.dto.activity.BannerDto;
import com.only.tech.dto.activity.BannerReqDto;
import com.only.tech.enums.PageEnum;

import java.util.List;

public interface BannerInfz {

    void deleteById(Long id);

    void saveOrUpdate(BannerDto dto);

    List<BannerDto> listByStatusAndChannelCode(String status, String channelCode);

    List<BannerDto> selectByConditionAndChannel(PageEnum pageEnum, String channel);
}
