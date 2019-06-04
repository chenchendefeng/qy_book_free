package com.only.tech.exposeinfz.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HUA MAN LOU
 * @since 2019/5/19
 */
@Data
@ApiModel("阅读足迹模型")
public class ReadFootprintDto implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long cuId;

    @ApiModelProperty(value = "书籍id")
    private Long bid;

    @ApiModelProperty(value = "书籍名")
    private String name;

    @ApiModelProperty(value = "封面图")
    private String coverImg;

    @ApiModelProperty(value = "阅读时间(上次)")
    private Date createDate;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("书籍分类")
    private String category;

    @ApiModelProperty("更新章节数")
    private Integer chapterCount;

}
