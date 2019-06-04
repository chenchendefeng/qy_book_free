package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.dto.AwardInfoDto;
import com.only.tech.exposeinfz.activity.dto.AwardItemDto;
import com.only.tech.exposeinfz.activity.dto.AwardReceiveDto;

import java.util.List;

public interface AwardReceiveInfz {


    /**
     * 分页查询
     * @param pageReq
     * @param uid
     * @param systemType
     * @param channel
     * @param createDate
     * @return
     */
    PageData<AwardReceiveDto> pageListByCondition(PageReq pageReq, Long uid, String systemType, String channel, String createDate);

}
