package com.only.tech.activity.service.biz;

import com.only.tech.dto.activity.PopupWindowDto;
import com.only.tech.entity.activity.PopupWindow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 弹窗 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-04-29
 */
public interface PopupWindowService extends IService<PopupWindow> {

    List<PopupWindowDto> list(String showPage, String channel, String clientType, Date date);

}
