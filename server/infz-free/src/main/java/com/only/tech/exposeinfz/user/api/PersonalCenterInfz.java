package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.PersonalCenter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/7
 */
public interface PersonalCenterInfz {
    PageData<PersonalCenter> pageByStatus(Integer status, PageReq pageReq);

    PersonalCenter getById(Integer id);

    boolean insert(PersonalCenter dto);

    boolean update(PersonalCenter dto);

    boolean updateStatus(Integer id, Integer status);

    boolean delete(Integer id);
}
