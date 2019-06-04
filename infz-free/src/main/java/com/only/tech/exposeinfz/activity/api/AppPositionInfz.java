package com.only.tech.exposeinfz.activity.api;

import com.only.tech.exposeinfz.activity.dto.ActivityRuleDto;
import com.only.tech.exposeinfz.activity.dto.AppPositionDto;

import java.util.List;

/**
 * 接口类：页面元素位置
 * @author shutong
 * @since 2019/03/14
 */
public interface AppPositionInfz {


    /**
     * 查询所有页面元素
     * @return
     */
    List<AppPositionDto> listAll();


}
