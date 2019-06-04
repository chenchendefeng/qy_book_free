package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.result.ResultDto;
import com.only.tech.exposeinfz.activity.dto.StartPageDto;

public interface StartPageInfz {

	void deleteById(Long id);

	void saveOrUpdate(StartPageDto dto);

    ResultDto<StartPageDto> list(String status, String channelCode);

}
