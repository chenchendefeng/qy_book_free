package com.only.tech.activity.service.facade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.activity.service.biz.PopupWindowService;
import com.only.tech.dto.activity.PopupWindowDto;
import com.only.tech.entity.activity.PopupWindow;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/29
 */
@Slf4j
@Service
public class PopupWindowFacade {

    @Autowired
    private PopupWindowService popupWindowService;


    public List<PopupWindowDto> list(Long cuid, String showPage, String channel, String clientType) {
        Date now = new Date();
        return popupWindowService.list(showPage,channel,clientType,now);
    }
}
