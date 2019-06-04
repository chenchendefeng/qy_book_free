package com.only.tech.entity.book;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * entity: 书架
 * @author shutong
 * @since 2019-04-25
 */
@Data
@ApiModel
public class BookShelf extends SuperEntity<BookShelf> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("书籍ID")
    private Long bid;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("加入书架量")
    @TableField(exist = false)
    private Integer addBookShelfCount;

}
