package com.only.tech.exposeinfz.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/20
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "书籍")
public class BookBaseDto implements Serializable {


    @ApiModelProperty(value = "书籍id",name = "BID")
    private Long BID;

    @ApiModelProperty(value = "书名")
    private String name;

    @ApiModelProperty(value = "作者名")
    private String author;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "封面图")
    private String coverImg;

    @ApiModelProperty(value = "阅读量")
    private Integer readedCount;

    @ApiModelProperty(value = "加入书架量")
    private Long addBookShelfCount;

    @ApiModelProperty(value = "授权方")
    private String source;
}
