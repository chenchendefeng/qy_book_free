package com.only.tech.dto.book;

import com.only.tech.base.SuperEntity;
import com.only.tech.entity.book.BookInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * dto: 书籍类目
 * @author shutong
 * @since 2019/05/06
 */
@Data
@ApiModel
public class BookCategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    //基本属性
    private Long id;

    @ApiModelProperty("类目名称")
    private String adCategory;

    @ApiModelProperty("男生女生")
    private String sexType;

    //其它属性
    @ApiModelProperty("书籍数")
    private Integer bookNum;

    @ApiModelProperty("子目录")
    private List<String> childCategoryList;

    @ApiModelProperty("代表小说")
    private BookInfo topBook;

}
