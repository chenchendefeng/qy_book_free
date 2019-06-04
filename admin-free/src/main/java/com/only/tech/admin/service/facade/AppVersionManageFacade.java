package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.admin.dto.AppVersionDto;
import com.only.tech.exposeinfz.user.api.AppVersionManageInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/3
 */
@Service
@Slf4j
public class AppVersionManageFacade {

    @Reference
    private AppVersionManageInfz appVersionManageInfz;

    public PageData<AppVersionDto> getPage(PageReq pageReq) {

        return appVersionManageInfz.getPage(pageReq);
    }

    public AppVersionDto getById(Integer id) {
        return appVersionManageInfz.getById(id);
    }

    public Boolean updateVsersion(AppVersionDto appVersionDto) {
        return appVersionManageInfz.updateVsersion(appVersionDto);
    }

    public Boolean deleteVsersion(Integer id) {
        return appVersionManageInfz.deleteVsersion(id);
    }

    public Boolean insertVsersion(AppVersionDto appVersionDto) {
        return appVersionManageInfz.insertVsersion(appVersionDto);
    }
}
