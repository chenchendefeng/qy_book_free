package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.dto.activity.BannerDto;
import com.only.tech.dto.admin.BannerReqDto;
import com.only.tech.exposeinfz.activity.api.BannerInfz;
import com.only.tech.exposeinfz.book.api.SearchWordInfz;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BannerFacade {

	@Reference
	private BannerInfz bannerInfz;

	/**
	 * 添加或者修改
	 * @param reqDto
	 * @throws ParseException
	 */
	public void saveOrUpdate(BannerReqDto reqDto) throws ParseException {
		BannerDto dto = new BannerDto();
		BeanUtils.copyProperties(reqDto, dto);

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String beginDateStr=reqDto.getBeginTime();
		String endDateStr=reqDto.getEndTime();
		if(StringUtils.isNotBlank(beginDateStr)){
			dto.setBeginTime(sdf.parse(beginDateStr));
		}

		if(StringUtils.isNotBlank(endDateStr)){
			dto.setEndTime(sdf.parse(endDateStr));
		}

		Date now=new Date();
		dto.setCreateTime(now);
		dto.setUpdateTime(now);

		this.bannerInfz.saveOrUpdate(dto);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id){
		this.bannerInfz.deleteById(id);
	}

	/**
	 * 条件列表
	 * @param status
	 * @param channelCode
	 * @return
	 */
    public List<BannerDto> listByCondition(String status, String channelCode) {
    	return this.bannerInfz.listByStatusAndChannelCode(status,channelCode);
    }

}
