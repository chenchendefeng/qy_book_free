package com.only.tech.exposeinfz.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/20
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "书籍详情")
public class BookInfoDto extends BookBaseDto{


    @ApiModelProperty("是否在书架(0:否;1:是)")
    private Integer shelfStatus;

    @ApiModelProperty("完结状态 （0：连载中 | 1：已完结）")
    private Integer finishFlag;

    @ApiModelProperty("总字数")
    private Long totalWordCount;

    @ApiModelProperty("描述")
    private String description;


}
