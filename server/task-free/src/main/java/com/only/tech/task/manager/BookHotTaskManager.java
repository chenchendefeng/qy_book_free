package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.book.api.BookHotInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/22
 */
@Slf4j
@Service
public class BookHotTaskManager {

    @Reference
    private BookHotInfz bookHotInfz;

    public void initHot() {
        bookHotInfz.initHot();
    }
}
