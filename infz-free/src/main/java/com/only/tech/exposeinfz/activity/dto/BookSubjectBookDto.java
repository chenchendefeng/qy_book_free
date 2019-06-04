package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO : 书籍专题-书籍列表
 * @author shutong
 * @since 2019-02-28
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class BookSubjectBookDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("书籍ID")
    private Long cBID;

    @ApiModelProperty("书籍名称")
    private String bookName;

    @ApiModelProperty("专题类型（weekRecommend 本周推荐 | freeTimeLimited 限时免费）")
    private String subjectType;

    @ApiModelProperty("专题ID")
    private Long subjectId;


}
