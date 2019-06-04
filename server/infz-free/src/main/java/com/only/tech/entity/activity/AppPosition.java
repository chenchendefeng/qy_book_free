package com.only.tech.entity.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实体： App位置
 * @author shutong
 * @since 2019/03/10
 */
@Data
@ApiModel
public class AppPosition extends SuperEntity<AppPosition> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private Long id;

    @ApiModelProperty("位置编码")
    @TableField("positionCode")
    private String positionCode;

    @ApiModelProperty("位置名称")
    @TableField("positionName")
    private String positionName;


}
