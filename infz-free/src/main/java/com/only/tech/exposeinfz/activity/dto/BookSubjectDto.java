package com.only.tech.exposeinfz.activity.dto;

import com.only.tech.exposeinfz.admin.dto.BookBaseDto;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO: 书籍专题
 * @author shutong
 * @since 2019-02-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class BookSubjectDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建人ID")
    private Long createrId;

    @ApiModelProperty("生效时间-开始")
    private String beginTime;

    @ApiModelProperty("生效时间-结束")
    private String endTime;

    @ApiModelProperty("发布状态（ 0: 未发布 | 1:发布 ）")
    private Integer status;

    @ApiModelProperty("书籍列表")
    private List<BookBaseDto> bookList;

    @ApiModelProperty("书籍ID列表")
    private  List<Long> cbidList;

    @ApiModelProperty("专题类型：（ weekRecommend:本周推荐  |  freeTimeLimited: 限时免费 | saleTimeLimited 限时特价 ）")
    private String subjectType;

    @ApiModelProperty("价格折扣（eg: 1.0）")
    private float discount;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("标题")
    private String bookName;

    @ApiModelProperty("是否可以领取：（true:可以领取 | false:不可以领取 ）")
    private boolean canTakeIt;

}
