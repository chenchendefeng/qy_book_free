package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.enums.InvitationTaskEnum;
import com.only.tech.exposeinfz.user.api.InvitationInfz;
import com.only.tech.user.service.facade.InvitationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
@Component
@Service(interfaceClass = InvitationInfz.class)
public class InvitationInfzImpl implements InvitationInfz {

    @Autowired
    private InvitationFacade invitationFacade;

    @Override
    public void finishTask(Long cuId, InvitationTaskEnum taskEnum, Date date) {
        invitationFacade.finishTask(cuId,taskEnum,date);
    }
}
