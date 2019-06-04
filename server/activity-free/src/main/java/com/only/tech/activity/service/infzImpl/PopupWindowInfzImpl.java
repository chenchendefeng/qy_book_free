package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.activity.service.biz.PopupWindowService;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.activity.PopupWindow;
import com.only.tech.exposeinfz.activity.api.PopupWindowInfz;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/29
 */
@Component
@Service(interfaceClass = PopupWindowInfz.class)
public class PopupWindowInfzImpl implements PopupWindowInfz {

    @Autowired
    private PopupWindowService popupWindowService;

    @Override
    public PageData<PopupWindow> getPage(PageReq pageReq, Integer status, String channel) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        QueryWrapper qw = new QueryWrapper();
        if (status != null){
            qw.eq("status",status);
        }
        if (StringUtils.isNotBlank(channel)){
            qw.eq("channel",channel);
        }
        popupWindowService.list(qw);

        PageData pageData = new PageData(page);
        return pageData;
    }

    @Override
    public PopupWindow detail(Integer id) {
        return popupWindowService.getById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return popupWindowService.removeById(id);
    }

    @Override
    public boolean update(PopupWindow popupWindow) {
        return popupWindowService.updateById(popupWindow);
    }

    @Override
    public boolean insert(PopupWindow popupWindow) {
        popupWindow.setCreateTime(new Date());
        return popupWindowService.save(popupWindow);
    }


}
