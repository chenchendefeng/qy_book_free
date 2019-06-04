package com.only.tech.task.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZHI ZUN BAO
 * @since 2019/2/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVisitorStatisticsTaskManager {

    @Autowired
    private VisitorStatisticsTaskManager visitorStatisticsTaskManager;

    @Test
    public void visitorStatistics(){
        String date = "2019-02-28 14:35:00";
        visitorStatisticsTaskManager.visitorStatistics(date);
    }
}
