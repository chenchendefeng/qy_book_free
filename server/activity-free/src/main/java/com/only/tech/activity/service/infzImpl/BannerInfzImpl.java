package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.activity.service.biz.BannerService;
import com.only.tech.dto.activity.BannerDto;
import com.only.tech.entity.activity.Banner;
import com.only.tech.enums.PageEnum;
import com.only.tech.exposeinfz.activity.api.BannerInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service(interfaceClass = BannerInfz.class)
@Component
public class BannerInfzImpl implements BannerInfz {



	@Autowired
	BannerService bannerService;

	@Override
	public void deleteById(Long id) {
		this.bannerService.removeById(id);
	}

	@Override
	public void saveOrUpdate(BannerDto dto) {
		Banner entity = new Banner();
		BeanUtils.copyProperties(dto, entity);
		bannerService.saveOrUpdate(entity);
	}

	@Override
	public List<BannerDto> listByStatusAndChannelCode(String status, String channelCode) {
		List<Banner> list=this.bannerService.listByStatusAndChannelCode(status,channelCode);
		List<BannerDto> resultList=new ArrayList<BannerDto>();
		if (!list.isEmpty()) {
			list.stream().forEach(record -> {
				BannerDto dto = new BannerDto();
				BeanUtils.copyProperties(record, dto);
				resultList.add(dto);
			});
		}
		return resultList;
	}

	@Override
	public List<BannerDto> selectByConditionAndChannel(PageEnum pageEnum, String channel) {

		List<Banner> bannerList = bannerService.selectByConditionAndChannel(pageEnum, channel);
		if (!bannerList.isEmpty()) {
			List<BannerDto> bannertDtoList = new ArrayList(bannerList.size());
			for (Banner banner:bannerList) {
				BannerDto bannerDto = new BannerDto();
				BeanUtils.copyProperties(banner,bannerDto);
				bannertDtoList.add(bannerDto);
			}
			return bannertDtoList;
		}

		return null;
	}

}
