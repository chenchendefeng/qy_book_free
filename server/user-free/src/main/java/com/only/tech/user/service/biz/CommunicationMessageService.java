package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.user.CommunicationMessageDto;
import com.only.tech.entity.user.CommunicationMessage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZHI
 * @since 2019-03-15
 */
public interface CommunicationMessageService extends IService<CommunicationMessage> {

    List<CommunicationMessageDto> getDtoList(Integer sendStatus, String startTime, String endTime);
}
