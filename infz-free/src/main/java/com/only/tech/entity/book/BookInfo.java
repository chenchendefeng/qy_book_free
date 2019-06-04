package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * entity: 书籍
 * @author shutong
 * @since 2019-04-26
 */
@Data
@ApiModel
public class BookInfo extends SuperEntity<BookInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("书籍ID")
    private Long bid;

    @ApiModelProperty("原书籍ID")
    private Long originalBid;

    @ApiModelProperty("书名")
    private String name;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("封面图")
    private String coverImg;

    @ApiModelProperty("完结状态 （0：连载中 | 1：已完结）")
    private Integer finishFlag;

    @ApiModelProperty("章节数")
    private Integer chapterCount;

    @ApiModelProperty("最近修改时间")
    private Long lastUpdateTime;

    @ApiModelProperty("分类")
    private String category;

    @ApiModelProperty("总字数")
    private Integer totalWordCount;

    @ApiModelProperty("上架状态 （0：下架 | 1：上架）")
    private Integer shelfStatus;

    @ApiModelProperty("书籍来源 （ twoCloo : 二层楼  |  tadu：塔读 ）")
    private String source;

}
