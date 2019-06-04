package com.only.tech.activity.common.dto;

import com.only.tech.dto.activity.WelfareDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/10
 */
@Data
@ApiModel("福利页数据")
public class WelfarePageDto implements Serializable {

    @ApiModelProperty("新手福利")
    private List<WelfareDto> noviceList;

    @ApiModelProperty("阅读福利")
    private List<WelfareDto> readList;

    @ApiModelProperty("日常福利")
    private List<WelfareDto> dailyList;
}
