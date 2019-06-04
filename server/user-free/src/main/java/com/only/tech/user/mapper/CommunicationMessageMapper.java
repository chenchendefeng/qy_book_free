package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.only.tech.dto.user.CommunicationMessageDto;
import com.only.tech.entity.user.CommunicationMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZHI
 * @since 2019-03-15
 */
@Repository
public interface CommunicationMessageMapper extends BaseMapper<CommunicationMessage> {

    List<CommunicationMessageDto> getDtoList(@Param("sendStatus") Integer sendStatus, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
