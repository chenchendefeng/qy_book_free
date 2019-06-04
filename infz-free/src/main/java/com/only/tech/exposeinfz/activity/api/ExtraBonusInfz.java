package com.only.tech.exposeinfz.activity.api;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/17
 */
public interface ExtraBonusInfz {
    void addMultiple(Long cuId, Date expiryTime);

    void reward(String dateTime);
}
