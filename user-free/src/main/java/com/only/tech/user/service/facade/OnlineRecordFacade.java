package com.only.tech.user.service.facade;

import com.only.tech.entity.user.OnlineRecord;
import com.only.tech.user.service.biz.OnlineRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/21
 */
@Service
public class OnlineRecordFacade {

    @Autowired
    private OnlineRecordService onlineRecordService;

    public boolean add(Long cuId) {
        OnlineRecord record = new OnlineRecord();
        record.setCuId(cuId);
        record.setUptime(new Date());

        onlineRecordService.save(record);

        return true;
    }
}
