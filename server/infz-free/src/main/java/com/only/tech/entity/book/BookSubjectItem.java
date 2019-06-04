package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * entity: 专题书籍
 * @author shutong
 * @since 2019-04-26
 */
@Data
@ApiModel
public class BookSubjectItem extends SuperEntity<BookSubjectItem> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("专题ID")
    private Long subjectId;

    @ApiModelProperty("书籍ID")
    private Long bid;


}
