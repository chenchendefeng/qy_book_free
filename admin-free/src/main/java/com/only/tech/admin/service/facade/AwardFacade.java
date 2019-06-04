package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.api.ActivityInfz;
import com.only.tech.exposeinfz.activity.api.AwardInfoInfz;
import com.only.tech.exposeinfz.activity.dto.ActivitysConfigDto;
import com.only.tech.exposeinfz.activity.dto.AwardInfoDto;
import com.only.tech.exposeinfz.activity.dto.AwardItemDto;
import com.only.tech.exposeinfz.activity.dto.AwardItemResDto;
import ooh.chaos.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 奖品
 * @author shutong
 * @since 2019/03/12
 */
@Service
public class AwardFacade {

	@Reference
	private ActivityInfz activityInfz;

    @Reference
    private AwardInfoInfz awardInfoInfz;

    /**
     * 分页条件查询
     * @param status
     * @return
     */
    public PageData<AwardInfoDto> pageListByCondition(PageReq pageReq, Integer status,String awardType) {
          return this.awardInfoInfz.pageListByCondition(pageReq,status,awardType);
    }

    /**
     * 添加or修改
     * @param awardInfoDto
     */
    public String saveOrUpdate(AwardInfoDto awardInfoDto) {
       return  this.awardInfoInfz.saveOrUpdate(awardInfoDto);
    }

    /**
     * 添加or修改
     * @param awardItemResDto
     */
    public void saveOrUpdateAwardItem(AwardItemResDto awardItemResDto) {
        String awardCode=awardItemResDto.getAwardCode();
        List<AwardItemDto> awardItemDtoList=awardItemResDto.getAwardItemDtoList();
        this.awardInfoInfz.saveOrUpdateAwardItem(awardCode,awardItemDtoList);
    }

    /**
     * 开启or关闭
     * @param id
     * @param status
     */
    public void updateStatus(Long id, Integer status) {
        this.awardInfoInfz.updateStatus(id,status);
    }

    /**
     * 查询所有
     * @return
     */
    public List<AwardInfoDto> listAll() {
        return this.awardInfoInfz.listAll();
    }


}
