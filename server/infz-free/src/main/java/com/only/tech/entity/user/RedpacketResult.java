package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzb
 * @since 2019-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RedpacketResult extends SuperEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableField("mchBillno")
    private String mchBillno;

    /**
     * 返回码
     */
    @TableField("returnCode")
    private String returnCode;

    /**
     * 返回信息
     */
    @TableField("returnMsg")
    private String returnMsg;

    /**
     * 业务结果
     */
    @TableField("resultCode")
    private String resultCode;

    /**
     * 错误码
     */
    @TableField("errCode")
    private String errCode;

    /**
     * 错误码描述
     */
    @TableField("errCodeDes")
    private String errCodeDes;

    /**
     * 商户id
     */
    @TableField("mchId")
    private String mchId;

    /**
     * 工作号id
     */
    private String wxappid;

    /**
     * 用户openid
     */
    @TableField("reOpenid")
    private String reOpenid;

    /**
     * 付款金额
     */
    @TableField("totalAmount")
    private Integer totalAmount;

    /**
     * 微信单号
     */
    @TableField("sendListid")
    private String sendListid;


}
