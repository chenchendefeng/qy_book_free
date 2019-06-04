package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/21
 */
@Data
@ApiModel("好友信息模型")
public class FriendInfoDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long cuId;

    @ApiModelProperty("云通信账户")
    private String identifier;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像路径")
    private String avatar;

    @ApiModelProperty("上线时间")
    private Date upTime;

    @ApiModelProperty("上线时间信息")
    private String timeMsg;

    @ApiModelProperty("是否通知（0：否；1：是）")
    private Integer notifyStatus;

}
