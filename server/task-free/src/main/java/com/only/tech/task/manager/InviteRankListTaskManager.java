package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.InviteRankTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/30
 */
@Slf4j
@Service
public class InviteRankListTaskManager {

    @Reference
    private InviteRankTaskInfz inviteRankTaskInfz;

    public void execute(String date) {
        inviteRankTaskInfz.rankStatistics(date);
    }
}
