package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.api.ActivityInfz;
import com.only.tech.exposeinfz.activity.dto.ActivitysConfigDto;
import org.springframework.stereotype.Service;

/**
 * facade: 卡片
 * @author shutong
 * @since 2019/03/08
 */
@Service
public class ActivityFacade {

	@Reference
	private ActivityInfz activityInfz;

    /**
     * 分页条件查询活动
     * @param status
     * @return
     */
    public PageData<ActivitysConfigDto> pageListByStatus(PageReq pageReq,Integer status) {
          return this.activityInfz.pageListByStatus(pageReq,status);
    }

    /**
     * 添加or删除
     * @param activitysConfigDto
     */
    public void saveOrUpdate(ActivitysConfigDto activitysConfigDto) {
        this.activityInfz.saveOrUpdate(activitysConfigDto);
    }

    /**
     * 开启or关闭
     * @param id
     * @param status
     */
    public void updateStatus(Long id, Integer status) {
        this.activityInfz.updateStatus(id,status);
    }
}
