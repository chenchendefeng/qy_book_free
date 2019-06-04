package com.only.tech.exposeinfz.user.api;

import com.only.tech.enums.InvitationTaskEnum;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
public interface InvitationInfz {
    void finishTask(Long cuId, InvitationTaskEnum finishOne, Date date);
}
