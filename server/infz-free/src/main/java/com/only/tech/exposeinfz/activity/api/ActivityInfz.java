package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.dto.ActivitysConfigDto;

import java.util.List;

/**
 * 接口类：活动
 * @author shutong
 * @since 2019/02/28
 */
public interface ActivityInfz {


    /**
     * 查询所有活动配置
     * @return
     */
    List<ActivitysConfigDto> listAll();

    /**
     * 分页条件查询活动
     * @param status
     * @return
     */
    PageData<ActivitysConfigDto> pageListByStatus(PageReq pageReq, Integer status);

    /**
     * 添加or删除
     * @param activitysConfigDto
     */
    void saveOrUpdate(ActivitysConfigDto activitysConfigDto);

    /**
     * 开启or关闭
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);
}
