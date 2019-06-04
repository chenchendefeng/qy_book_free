package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.StartPageReqDto;
import com.only.tech.exposeinfz.activity.api.StartPageInfz;
import com.only.tech.exposeinfz.activity.dto.StartPageDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class StartPageFacade {


	@Reference
	private StartPageInfz startPageInfz;

	/**
	 * 添加或者修改开屏页
	 * @param reqDto
	 * @return
	 */
	public void saveOrUpdate(StartPageReqDto reqDto) throws ParseException {
		StartPageDto dto = new StartPageDto();
		BeanUtils.copyProperties(reqDto, dto);

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String beginDateStr=reqDto.getBeginDate();
		String endDateStr=reqDto.getEndDate();
		if(StringUtils.isNotBlank(beginDateStr)){
			dto.setBeginDate(sdf.parse(beginDateStr));
		}

		if(StringUtils.isNotBlank(endDateStr)){
			dto.setEndDate(sdf.parse(endDateStr));
		}

		this.startPageInfz.saveOrUpdate(dto);
	}

	/**
	 * 删除开屏页（包含OSS文件）
	 * @param id
	 */
	public void deleteById(Long id){
		this.startPageInfz.deleteById(id);
	}

	/**
	 * 开屏页列表
	 * @param status
	 * @param channelCode
	 * @return
	 */
    public ResultDto list(String status, String channelCode) {
    	return this.startPageInfz.list(status,channelCode);
    }



}
