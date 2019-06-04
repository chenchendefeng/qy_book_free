package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.exposeinfz.activity.api.ActivityInfz;
import com.only.tech.exposeinfz.activity.api.PopupWindowInfz;
import com.only.tech.exposeinfz.activity.dto.ActivitysConfigDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 活动配置
 * @author shutong
 * @since 2019/02/28
 */
@Service
public class ActivityConfigFacade {

	@Reference
	private PopupWindowInfz popupWindowInfz;

	@Reference
	private ActivityInfz activityInfz;


	public List<ActivitysConfigDto> listAll() {
		return this.activityInfz.listAll();
	}
}
