package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.admin.PopupWindowReq;
import com.only.tech.entity.activity.PopupWindow;
import com.only.tech.exposeinfz.activity.api.PopupWindowInfz;
import ooh.chaos.util.DateFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PopupWindowFacade {

	@Reference
	private PopupWindowInfz popupWindowInfz;

	public PageData<PopupWindow> page(PageReq pageReq, String channel, Integer status) {
		return popupWindowInfz.getPage(pageReq, status, channel);
	}

	public PopupWindow detail(Integer id) {
		return popupWindowInfz.detail(id);
	}

	public boolean delete(Integer id) {
		return popupWindowInfz.delete(id);
	}

	public boolean update(PopupWindowReq  req) {

		PopupWindow popupWindow = new PopupWindow();
		convert(req, popupWindow);

		return popupWindowInfz.update(popupWindow);
	}


	public boolean insert(PopupWindowReq req) {

		PopupWindow popupWindow = new PopupWindow();
		convert(req, popupWindow);

		return popupWindowInfz.insert(popupWindow);
	}

	private void convert(PopupWindowReq req, PopupWindow popupWindow) {
		BeanUtils.copyProperties(req, popupWindow);
		popupWindow.setId(req.getId());
		String startTimeStr = req.getStartTimeStr();
		if (StringUtils.isNotBlank(startTimeStr)){
			Date startTime = DateFormatUtil.parse(startTimeStr);
			popupWindow.setStartTime(startTime);
		}
		String endTimeStr = req.getEndTimeStr();
		if (StringUtils.isNotBlank(endTimeStr)){
			Date endTime = DateFormatUtil.parse(endTimeStr);
			popupWindow.setEndTime(endTime);
		}
	}
}
