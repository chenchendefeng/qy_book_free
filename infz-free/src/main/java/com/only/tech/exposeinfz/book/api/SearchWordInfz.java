package com.only.tech.exposeinfz.book.api;

import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.SearchWordDto;


public interface SearchWordInfz {

	void deleteById(Long id);

	void saveOrUpdate(SearchWordDto dto);

    ResultDto<SearchWordDto> getList(String status, String channelCode);

}
