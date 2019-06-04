package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.dto.ActivityRuleDto;
import com.only.tech.exposeinfz.activity.dto.ActivitysConfigDto;

import java.util.List;

/**
 * 接口类：活动规则
 * @author shutong
 * @since 2019/02/28
 */
public interface ActivityRuleInfz {


    /**
     * 查询所有活动规则
     * @return
     */
    List<ActivityRuleDto> listAll();


}
