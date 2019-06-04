package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO：机器人评论
 * @author shutong
 * @since 2019/03/12
 */
@Data
@ApiModel
public class RobotCommendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("机器人ID尾号")
    private Integer robotIdTail;

    @ApiModelProperty("评论库ID尾号")
    private Integer recommendIdTail;

    @ApiModelProperty("书籍编号尾号")
    private Integer cbidTail;

    @ApiModelProperty("机器人数")
    private Integer robotNum;

    @ApiModelProperty("评论数")
    private Integer recommendNum;

}
