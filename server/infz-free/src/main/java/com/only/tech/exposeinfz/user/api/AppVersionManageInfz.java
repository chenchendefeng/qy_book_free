package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.admin.dto.AppVersionDto;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/3
 */
public interface AppVersionManageInfz {

    PageData<AppVersionDto> getPage(PageReq pageReq);

    AppVersionDto getById(Integer id);

    Boolean updateVsersion(AppVersionDto appVersionDto);

    Boolean deleteVsersion(Integer id);

    Boolean insertVsersion(AppVersionDto appVersionDto);
}
