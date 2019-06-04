package com.only.tech.activity.service.biz;

import com.only.tech.dto.activity.PopupWindowDto;
import com.only.tech.entity.activity.PopupWindow;
import com.only.tech.activity.mapper.PopupWindowMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 弹窗 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-04-29
 */
@Service
public class PopupWindowServiceImpl extends ServiceImpl<PopupWindowMapper, PopupWindow> implements PopupWindowService {

    @Autowired
    private PopupWindowMapper popupWindowMapper;

    @Override
    public List<PopupWindowDto> list(String showPage, String channel, String clientType, Date date) {
        return popupWindowMapper.list(showPage,channel,clientType,date);
    }

}
