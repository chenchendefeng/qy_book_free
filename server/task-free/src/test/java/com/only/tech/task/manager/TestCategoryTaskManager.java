package com.only.tech.task.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCategoryTaskManager {

    @Autowired
    private CategoryTaskManager categoryTaskManager;


    /**
     * 加载所有分类数据
     */
    @Test
    public void loadAll(){
        categoryTaskManager.execute();

    }

}
