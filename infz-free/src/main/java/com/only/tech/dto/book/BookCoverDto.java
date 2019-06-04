package com.only.tech.dto.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/7
 */
@Data
@ApiModel("书籍封面")
public class BookCoverDto implements Serializable {

    @ApiModelProperty("书籍ID")
    private Long bid;

    @ApiModelProperty("书名")
    private String name;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("封面图")
    private String coverImg;

}
