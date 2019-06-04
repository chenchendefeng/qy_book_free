package com.only.tech.dto.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 参数实体类：横幅广告轮播图
 *
 * @author HUA MAN LOU
 * @date 2019/4/29
 * @version 1.0
 */
@Data
@ApiModel
public class BannerReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("位置(recommend推荐、girl女生、boy男生、personalCenter个人中心、categoryBoy分类-男生、categoryGirl分类-女生)")
    @NotBlank(message = "轮播图位置不能为空")
    private String position;

    @ApiModelProperty("渠道")
    private String channel;

    @ApiModelProperty("移动端类型（Android | IOS ）")
    private String systemType;

}
