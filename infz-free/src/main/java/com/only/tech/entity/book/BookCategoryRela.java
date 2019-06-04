package com.only.tech.entity.book;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * entity: source类目关联爱读类目
 * @author shutong
 * @since 2019/05/25
 */
@Data
@ApiModel
public class BookCategoryRela extends SuperEntity<BookCategoryRela> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("source类目")
    private String category;

    @ApiModelProperty("爱读类目")
    private String adCategory;

}
