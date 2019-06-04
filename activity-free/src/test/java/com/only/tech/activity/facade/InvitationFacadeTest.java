package com.only.tech.activity.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.activity.ActivityFreeApplicationTests;
import com.only.tech.enums.InvitationTaskEnum;
import com.only.tech.exposeinfz.user.api.InvitationInfz;
import org.junit.Test;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
public class InvitationFacadeTest extends ActivityFreeApplicationTests {

    @Reference
    private InvitationInfz invitationInfz;


    @Test
    public void finishTask(){
        Long cuId = Long.valueOf("1");
        Date now = new Date();

        invitationInfz.finishTask(cuId, InvitationTaskEnum.FINISH_THREE,now);
    }
}
