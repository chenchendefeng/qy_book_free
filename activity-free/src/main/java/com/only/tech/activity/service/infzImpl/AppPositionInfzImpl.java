package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.activity.service.biz.AppPositionService;
import com.only.tech.entity.activity.AppPosition;
import com.only.tech.exposeinfz.activity.api.ActivityRuleInfz;
import com.only.tech.exposeinfz.activity.api.AppPositionInfz;
import com.only.tech.exposeinfz.activity.dto.ActivityRuleDto;
import com.only.tech.exposeinfz.activity.dto.AppPositionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * 接口实现类： 页面元素位置
 */
@Slf4j
@Service(interfaceClass = AppPositionInfz.class)
@Component
public class AppPositionInfzImpl implements AppPositionInfz {

	@Autowired
	AppPositionService positionService;


	/**
	 * 查询所有
	 * @return
	 */
	@Override
	public List<AppPositionDto> listAll() {
		List<AppPositionDto> dtoList=new ArrayList<AppPositionDto>();
		List<AppPosition>  positionList=this.positionService.listAll();
		if(positionList!=null || positionList.size()>0){
			for(AppPosition position : positionList){
				AppPositionDto dto= new AppPositionDto();
				BeanUtils.copyProperties(position,dto);
				dtoList.add(dto);
			}
		}
		return dtoList;

	}


}
