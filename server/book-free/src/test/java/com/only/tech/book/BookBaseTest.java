package com.only.tech.book;

import ooh.chaos.service.OSSService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookBaseTest {

    @Autowired
    private OSSService ossService;

    @Test
    public void oss(){
        Long bid = Long.valueOf("-1001");
        Long cid = Long.valueOf("-1");
        String content = "123456789";

        boolean saveContent = ossService.saveContent(bid, cid, content);
        Assert.assertNotNull(saveContent);
    }
}
