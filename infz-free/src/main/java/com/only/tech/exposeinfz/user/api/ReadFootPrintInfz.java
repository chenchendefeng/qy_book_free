package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.user.dto.ReadFootprintDto;

import java.util.List;

/**
 * 服务接口：用户阅读足迹
 * 
 * @author HUA MAN LOU
 * @date 2019/5/19
 */
public interface ReadFootPrintInfz {


	/**
	 * 查询用户阅读足迹
	 * @param cuId
	 * @return
	 */
	List<ReadFootprintDto> listByUid(Long cuId);

	/**
	 * 分页查询阅读足迹
	 * @param pageReq
	 * @param cuId
	 * @return
	 */
    PageData<ReadFootprintDto> pageListMyBookShelf(PageReq pageReq, Long cuId);
}
