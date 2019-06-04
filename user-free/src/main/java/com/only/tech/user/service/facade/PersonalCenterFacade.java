package com.only.tech.user.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.dto.activity.BannerDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.entity.user.PersonalCenter;
import com.only.tech.enums.PageEnum;
import com.only.tech.exposeinfz.activity.api.BannerInfz;
import com.only.tech.user.dto.CustomerAccountInfoDto;
import com.only.tech.user.dto.PersonalCenterDto;
import com.only.tech.user.dto.PersonalCenterPageDto;
import com.only.tech.user.service.biz.PersonalCenterService;
import com.only.tech.user.service.biz.ReadTimePerdayService;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/7
 */
@Slf4j
@Service
public class PersonalCenterFacade {

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private PersonalCenterService personalCenterService;

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private InvitationFacade invitationFacade;

    @Autowired
    private ReadTimePerdayService readTimePerdayService;

    @Reference
    private BannerInfz bannerInfz;


    public PersonalCenterPageDto getPage(Long cuId, String channel) {
        PersonalCenterPageDto dto = new PersonalCenterPageDto();
        //模块
        List<PersonalCenterDto> list = list();
        dto.setModules(list);

        //钱包红点
        if (cuId != null){

            Customer customer = customerFacade.getByCuid(cuId);
            if (customer != null){
                CustomerAccountInfoDto accountInfoDto = new CustomerAccountInfoDto();
                accountInfoDto.setCuId(customer.getCuId());
                accountInfoDto.setNickName(customer.getNickName());
                accountInfoDto.setAvatar(customer.getAvatar());
                String invitationCode = customer.getInvitationCode();
                if (StringUtils.isBlank(invitationCode)){
                    invitationCode = invitationFacade.getCode(cuId);
                }
                accountInfoDto.setInvitationCode(invitationCode);

                CustomerAccount customerAccount = customerAccountFacade.getCuId(cuId);
                accountInfoDto.setRmb(customerAccount.getRmb());
                accountInfoDto.setGold(customerAccount.getGold());

                Integer readTime = readTimePerdayService.getReadTime(cuId, DateFormatUtil.getCurrentDate());
                accountInfoDto.setReadTime(readTime);

                dto.setCustomerAccountInfo(accountInfoDto);
            }


            boolean change = customerAccountFacade.checkChange(cuId);
            dto.setWalletRedDot(change?1:0);
        }

        //banners
        List<BannerDto> bannerDtoList = bannerInfz.selectByConditionAndChannel(PageEnum.PERSONAL_CENTER_PAGE,channel);
        dto.setBannerDtoList(bannerDtoList);


        return dto;
    }

    public List<PersonalCenterDto> list() {
        Wrapper qw = new QueryWrapper<>().eq("status",1).orderByAsc("sort");
        List<PersonalCenter> list = personalCenterService.list(qw);

        List<PersonalCenterDto> dtoList = new ArrayList<>();

        if (!list.isEmpty()){
            for (PersonalCenter data: list) {
                PersonalCenterDto dto = new PersonalCenterDto();
                BeanUtils.copyProperties(data,dto);
                dtoList.add(dto);
            }
        }

        return dtoList;
    }

}
