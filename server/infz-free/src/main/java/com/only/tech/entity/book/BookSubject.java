package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * entity: 书籍主题
 * @author shutong
 * @since 2019-04-26
 */
@Data
@ApiModel
public class BookSubject extends SuperEntity<BookSubject> {

    private static final long serialVersionUID = 1L;

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

}
