package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * entity: 章节
 * @author shutong
 * @since 2019-04-26
 */
@Data
@ApiModel
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("书籍ID")
    private Long bid;

    @ApiModelProperty("章节ID")
    private Long cid;

    @ApiModelProperty("卷id")
    private Long vid;

    @ApiModelProperty("原书籍ID")
    private Long originalBid;

    @ApiModelProperty("排序")
    private Integer displayOrder;

    @ApiModelProperty("章节标题")
    private String chapterTitle;

    @ApiModelProperty("修改时间")
    private Long updateTime;

    @ApiModelProperty("字数")
    private Integer wordNum;

    @ApiModelProperty("VIP状态 （0：否 | 1：是）")
    private Integer vipStatus;

    @ApiModelProperty("是否导入内容 （0：否 | 1：是）")
    private Integer importContent;

}
