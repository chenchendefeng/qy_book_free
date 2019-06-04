package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.activity.PopupWindow;
import com.only.tech.exposeinfz.activity.dto.PopupWindowConfigDto;

public interface PopupWindowInfz {
	PageData<PopupWindow> getPage(PageReq pageReq, Integer status, String channel);

	boolean delete(Integer id);

	boolean update(PopupWindow dto);

	boolean insert(PopupWindow dto);

	PopupWindow detail(Integer id);
}
