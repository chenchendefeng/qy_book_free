package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO: 书籍评论点赞
 * @author shutong
 * @since 2019-03-08
 */
@Data
@ApiModel
public class BookCommendSaygoodDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("书籍ID")
    private Long cBID;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("评论ID")
    private Long commendId;

    @ApiModelProperty("创建时间")
    private Date createTime;

}
