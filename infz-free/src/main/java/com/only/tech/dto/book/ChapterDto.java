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
@ApiModel("章节 ")
public class ChapterDto implements Serializable {

    @ApiModelProperty("书籍ID")
    private Long bid;

    @ApiModelProperty("章节ID")
    private Long cid;

    @ApiModelProperty("章节标题")
    private String chapterTitle;

    @ApiModelProperty("oss路径")
    private String ossUrl;
}
