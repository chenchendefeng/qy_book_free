package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ReadFootprint;
import com.only.tech.exposeinfz.user.api.ReadFootPrintInfz;
import com.only.tech.exposeinfz.user.dto.ReadFootprintDto;
import com.only.tech.user.service.biz.ReadFootprintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现类：用户阅读足迹
 * @author HUA MAN LOU
 * @date 2019/5/19
 */
@Slf4j
@Service(interfaceClass = ReadFootPrintInfz.class)
@Component
public class ReadFootPrintInfzImpl implements ReadFootPrintInfz {

	@Autowired
	private ReadFootprintService readFootprintService;

	@Override
	public List<ReadFootprintDto> listByUid(Long uid) {
		List<ReadFootprint> readFootprintList = this.readFootprintService.listByUid(uid);
		List<ReadFootprintDto> dtoList=new ArrayList<ReadFootprintDto>();

		for(ReadFootprint foot:readFootprintList ){
			ReadFootprintDto dto=new ReadFootprintDto();
			dto.setBid(foot.getBID());
			dto.setCreateDate(foot.getCreateDate());
			dto.setCuId(foot.getCuId());
			dtoList.add(dto);
		}
		return dtoList;
	}


	@Override
	public PageData<ReadFootprintDto> pageListMyBookShelf(PageReq pageReq, Long uid) {

		Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

		List<ReadFootprint> readFootprintList = this.readFootprintService.listByUid(uid);
		List<ReadFootprintDto> dtoList=new ArrayList<ReadFootprintDto>();

		for(ReadFootprint foot:readFootprintList ){
			ReadFootprintDto dto=new ReadFootprintDto();
			dto.setBid(foot.getBID());
			dto.setCreateDate(foot.getCreateDate());
			dto.setCuId(foot.getCuId());
			dtoList.add(dto);
		}

		PageData pageData = new PageData(page);
		pageData.setData(dtoList);
		return pageData;
	}
}
