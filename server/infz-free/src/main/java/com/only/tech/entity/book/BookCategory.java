package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * entity: 书籍类目
 * @author shutong
 * @since 2019/05/06
 */
@Data
@ApiModel
public class BookCategory extends SuperEntity<BookCategory> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("类目名称")
    private String adCategory;

    @ApiModelProperty("男生女生")
    private String sexType;

}
