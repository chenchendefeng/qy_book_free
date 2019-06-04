package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.dto.user.CommunicationMessageDto;
import com.only.tech.entity.user.CommunicationMessage;
import com.only.tech.user.mapper.CommunicationMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZHI
 * @since 2019-03-15
 */
@Service
public class CommunicationMessageServiceImpl extends ServiceImpl<CommunicationMessageMapper, CommunicationMessage> implements CommunicationMessageService {

    @Autowired
    private CommunicationMessageMapper messageMapper;

    @Override
    public List<CommunicationMessageDto> getDtoList(Integer sendStatus, String startTime, String endTime) {
        return messageMapper.getDtoList(sendStatus, startTime, endTime);
    }
}
