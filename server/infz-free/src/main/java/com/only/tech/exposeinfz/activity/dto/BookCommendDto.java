package com.only.tech.exposeinfz.activity.dto;

import com.only.tech.exposeinfz.user.dto.UserDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * dto: 书籍评论
 * @author shutong
 * @since 2019-03-08
 */
@Data
@ApiModel
public class BookCommendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("书籍ID")
    private Long cBID;

    @ApiModelProperty("评论打星（0-5颗行）")
    private Integer starNum;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("审核状态（ unchecked:未评审 | passed:审核通过 | nopass: 审核未通过 ）")
    private String status;

    @ApiModelProperty("是否置顶推荐 （ top: 置顶推荐  | notop: 不置顶推荐 ）")
    private String isTop;

    @ApiModelProperty("点赞数量")
    private Integer sayGoodNum;

    @ApiModelProperty("查看数量")
    private Integer clickNum;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("点赞人列表")
    private List<UserDto> saygoodUserList;

    @ApiModelProperty("当前用户是否已经点赞（ 1:是 | 0:否）")
    private Integer isSaygood;

    @ApiModelProperty("用户昵称")
    private String userName;

    @ApiModelProperty("书籍名称")
    private String bookName;

    @ApiModelProperty("头像图片")
    private String avatar;

    @ApiModelProperty("作者")
    private String authorName;

    @ApiModelProperty("书籍封面")
    private String coverUrl;


}
