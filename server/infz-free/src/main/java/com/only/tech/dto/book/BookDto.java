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
@ApiModel("书籍模型")
public class BookDto implements Serializable {

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

    @ApiModelProperty("完结状态 （0：连载中 | 1：已完结）")
    private Integer finishFlag;

    @ApiModelProperty("收藏")
    private Long collectionCount;

    @ApiModelProperty("阅读")
    private Long readedCount;

    @ApiModelProperty("在读")
    private Long readingCount;

    @ApiModelProperty("总字数")
    private Long totalWordCount;

    @ApiModelProperty("分类")
    private String category;

    @ApiModelProperty("是否在书架(0:否;1:是)")
    private Integer onShelf;

    @ApiModelProperty("章节数")
    private Integer chapterCount;


}
