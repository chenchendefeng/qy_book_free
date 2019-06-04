package com.only.tech.dto.book;

import com.only.tech.entity.book.BookInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO: 书籍专题请求模型
 * @author shutong
 * @since 2019/04/26
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel("书籍")
public class BookSubjectReqDto implements Serializable {

    //------------------基本属性---------------------------//

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("副标题")
    private String title2;

    @ApiModelProperty("标题颜色")
    private String titleRGB;

    @ApiModelProperty("副标题颜色")
    private String title2RGB;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("显示排序 （ 默认:0 ）")
    private Integer displayOrder;

    @ApiModelProperty("上架状态 （0：未上架 | 1：已上架 ）")
    private Integer status;

    @ApiModelProperty("类型 （boy:男生 | girl：女生 ）")
    private String subjectType;

    //------------------其它属性---------------------------//
    @ApiModelProperty("书籍ID列表")
    private  List<Long> bidList;

}
