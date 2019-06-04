package com.only.tech.entity.activity;

import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 开屏配置
 * @author shutong
 * @since 2019-01-16
 */
@Data
@ApiModel
public class StartPage extends SuperEntity<StartPage> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文件类型  （ pic-图片 | gif-动图 | video-视频 )")
    private String fileType;

    @ApiModelProperty("文件地址")
    private  String fileUrl;

    @ApiModelProperty("有效期-开始时间")
    private Date beginDate;

    @ApiModelProperty("有效期-结束时间")
    private Date endDate;

    @ApiModelProperty("是否启用  （ 1-启用  | 0-停用 ）")
    private Integer status;

    @ApiModelProperty(" 渠道编号array ( 多个渠道号用\",\"分隔 )")
    private String channelCodes;

    @ApiModelProperty("客户端 (all-苹果&安卓 | ios-苹果手机  | android-安卓手机 )")
    private String clientType;

}
