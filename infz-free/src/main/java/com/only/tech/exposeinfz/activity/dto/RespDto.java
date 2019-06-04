package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * response DTO
 * @author shutong
 * @since 2019/03/20
 */
@Data
@ApiModel
public class RespDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private List<Long> errorList;

    @ApiModelProperty("错误提示")
    private String errorMsg;

    @ApiModelProperty("是否成功")
    private boolean success;


}
