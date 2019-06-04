package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.admin.dto.AppVersionDto;
import com.only.tech.exposeinfz.user.api.AppVersionManageInfz;
import com.only.tech.user.service.facade.AppVersionManageFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/3
 */
@Slf4j
@Service(interfaceClass = AppVersionManageInfz.class)
@Component
public class AppVersionManageInfzImpl implements AppVersionManageInfz {

    @Autowired
    private AppVersionManageFacade appVersionManageFacade;

    @Override
    public PageData<AppVersionDto> getPage(PageReq pageReq) {
        return appVersionManageFacade.getPage(pageReq);
    }

    @Override
    public AppVersionDto getById(Integer id) {
        return appVersionManageFacade.getById(id);
    }

    @Override
    public Boolean updateVsersion(AppVersionDto appVersionDto) {
        return appVersionManageFacade.updateVsersion(appVersionDto);
    }

    @Override
    public Boolean deleteVsersion(Integer id) {
        return appVersionManageFacade.deleteVsersion(id);
    }

    @Override
    public Boolean insertVsersion(AppVersionDto appVersionDto) {
        return appVersionManageFacade.insertVsersion(appVersionDto);
    }
}
