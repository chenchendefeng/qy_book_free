package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.PersonalCenter;
import com.only.tech.exposeinfz.user.api.PersonalCenterInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/7
 */
@Slf4j
@Service
public class PersonalCenterFacade {

    @Reference
    private PersonalCenterInfz personalCenterInfz;

    public PageData<PersonalCenter> pageByStatus(Integer status, PageReq pageReq) {
        return personalCenterInfz.pageByStatus(status,pageReq);
    }

    public PersonalCenter getById(Integer id) {
        return personalCenterInfz.getById(id);
    }

    public boolean insert(PersonalCenter dto) {
        return personalCenterInfz.insert(dto);
    }

    public boolean update(PersonalCenter dto) {
        return personalCenterInfz.update(dto);
    }

    public boolean updateStatus(Integer id, Integer status) {
        return personalCenterInfz.updateStatus(id,status);
    }

    public boolean delete(Integer id) {
        return personalCenterInfz.delete(id);
    }
}
