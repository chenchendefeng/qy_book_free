package com.only.tech.exposeinfz.activity.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * DTO： App位置
 * @author shutong
 * @since 2019/03/12
 */
@Data
@ApiModel
public class AppPositionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("位置编码")
    private String positionCode;

    @ApiModelProperty("位置名称")
    private String positionName;


}
