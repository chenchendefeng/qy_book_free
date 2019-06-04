package com.only.tech.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.activity.PopupWindowDto;
import com.only.tech.entity.activity.PopupWindow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 弹窗 Mapper 接口
 * </p>
 *
 * @author zzb
 * @since 2019-04-29
 */
@Repository
public interface PopupWindowMapper extends BaseMapper<PopupWindow> {

    List<PopupWindowDto> list(@Param("showPage") String showPage, @Param("channel")String channel, @Param("clientType")String clientType,@Param("date") Date date);
}
