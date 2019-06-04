package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.api.ActivityInfz;
import com.only.tech.exposeinfz.activity.api.AwardInfoInfz;
import com.only.tech.exposeinfz.activity.api.AwardReceiveInfz;
import com.only.tech.exposeinfz.activity.dto.AwardInfoDto;
import com.only.tech.exposeinfz.activity.dto.AwardItemDto;
import com.only.tech.exposeinfz.activity.dto.AwardItemResDto;
import com.only.tech.exposeinfz.activity.dto.AwardReceiveDto;
//import com.only.tech.exposeinfz.user.api.UserInfz;
import com.only.tech.exposeinfz.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 奖品
 * @author shutong
 * @since 2019/03/12
 */
@Service
public class AwardReceiveFacade {

	@Reference
    private AwardReceiveInfz awardReceiveInfz;

    @Reference
//    private UserInfz userInfz;

    /**
     * 分页查询
     * @param pageReq
     * @param uid
     * @param systemType
     * @param channel
     * @param createDate
     * @return
     */
    public PageData<AwardReceiveDto> pageListByCondition(PageReq pageReq, Long uid, String systemType, String channel, String createDate) {
        PageData<AwardReceiveDto> pageData= this.awardReceiveInfz.pageListByCondition(pageReq,uid,systemType,channel,createDate);
        List<AwardReceiveDto> awardReceiveDtoList=pageData.getData();

        for(AwardReceiveDto awardReceiveDto : awardReceiveDtoList){
            Long uid_temp=awardReceiveDto.getUid();
//            UserDto userDto=userInfz.getByUid(uid);
//            awardReceiveDto.setUserName(userDto==null?"":userDto.getName());
        }
        return pageData;
    }
}
