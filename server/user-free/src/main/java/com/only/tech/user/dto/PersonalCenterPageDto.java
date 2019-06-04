package com.only.tech.user.dto;

import com.only.tech.dto.activity.BannerDto;
import com.only.tech.dto.user.CustomerAccountDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/30
 */
@Data
@ApiModel("个人中心数据模型")
public class PersonalCenterPageDto implements Serializable {

    @ApiModelProperty("账户信息")
    private CustomerAccountInfoDto customerAccountInfo;

    @ApiModelProperty("banner")
    private List<BannerDto> bannerDtoList;

    @ApiModelProperty("模块")
    private List<PersonalCenterDto> modules;

    @ApiModelProperty("钱包红点（0：无，1：有）")
    private Integer walletRedDot;

}
