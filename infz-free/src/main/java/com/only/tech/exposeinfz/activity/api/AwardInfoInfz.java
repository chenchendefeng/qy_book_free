package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.dto.AwardInfoDto;
import com.only.tech.exposeinfz.activity.dto.AwardItemDto;

import java.util.List;

public interface AwardInfoInfz {
	
	AwardInfoDto selectById(Long awardId);

    /**
     * 分页查询
     * @param pageReq
     * @param status
     * @param awardType
     * @return
     */
    PageData<AwardInfoDto> pageListByCondition(PageReq pageReq, Integer status,String awardType);

    /**
     * 添加or修改
     * @param awardInfoDto
     */
    String saveOrUpdate(AwardInfoDto awardInfoDto);

    /**
     * 开启or关闭
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);

    /**
     * 查询所有
     * @return
     */
    List<AwardInfoDto> listAll();

    /**
     * 添加实物奖品
     * @param awardCode
     * @param awardItemDtoList
     */
    public void saveOrUpdateAwardItem(String awardCode,List<AwardItemDto> awardItemDtoList);
}
