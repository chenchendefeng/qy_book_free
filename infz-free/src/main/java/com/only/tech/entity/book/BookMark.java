package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * entity: 书籍
 * @author shutong
 * @since 2019/04/26
 */
@Data
@ApiModel
public class BookMark extends SuperEntity<BookMark> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("书籍ID")
    private Long bid;

    @ApiModelProperty("性别标示 （ boy:男 | girl:女）")
    private String sexMark;

    @ApiModelProperty("原始目录")
    private String category;

    @ApiModelProperty("爱读目录")
    private String adCategory;

}
