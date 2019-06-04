package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.activity.service.biz.StartPageService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.activity.StartPage;
import com.only.tech.exposeinfz.activity.api.StartPageInfz;
import com.only.tech.exposeinfz.activity.dto.PopupWindowConfigDto;
import com.only.tech.exposeinfz.activity.dto.StartPageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * infz实现类：开屏页
 * @author shutong
 * @since 2019/05/06
 */
@Slf4j
@Service(interfaceClass = StartPageInfz.class)
@Component
public class StartPageInfzImpl implements StartPageInfz {

	@Autowired
	StartPageService startPageService;

	@Override
	public void deleteById(Long id) {
		this.startPageService.deleteById(id);
	}

	@Override
	public void saveOrUpdate(StartPageDto dto) {
		StartPage entity = new StartPage();
		BeanUtils.copyProperties(dto, entity);
		startPageService.saveOrUpdate(entity);
	}

	@Override
	public ResultDto<StartPageDto> list(String status, String channelCode) {

		List<StartPage> list=startPageService.listByStatusAndChannelCode(status, channelCode);
		List<StartPageDto> resultList=new ArrayList<StartPageDto>();

		if (!list.isEmpty()) {
			list.stream().forEach(record -> {
				StartPageDto dto = new StartPageDto();
				BeanUtils.copyProperties(record, dto);
				resultList.add(dto);
			});
		}
		return ResultDto.succesResult(resultList);
	}


}
