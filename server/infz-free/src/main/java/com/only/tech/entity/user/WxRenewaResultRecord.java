package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 微信自动续费签约/解约返回结果记录
 * </p>
 *
 * @author ZHI
 * @since 2019-01-17
 */
@Data
public class WxRenewaResultRecord extends SuperEntity<WxRenewaResultRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 商户号
     */
    @TableField("mchId")
    private String mchId;

    /**
     * 签约协议号
     */
    @TableField("contractCode")
    private String contractCode;

    /**
     * 模板id
     */
    @TableField("planId")
    private String planId;

    /**
     * 用户标识
     */
    private String openid;

    /**
     * 签名
     */
    private String sign;

    /**
     * 变更类型(ADD--签约 DELETE--解约)
     */
    @TableField("changeType")
    private String changeType;

    /**
     * 操作时间
     */
    @TableField("operateTime")
    private LocalDateTime operateTime;

    /**
     * 委托代扣协议id
     */
    @TableField("contractId")
    private String contractId;

    /**
     * 协议到期时间
     */
    @TableField("contractExpiredTime")
    private Date contractExpiredTime;

    /**
     * 协议解约方式(0-未解约 1-有效期过自动解约 2-用户主动解约 3-商户API解约4-商户平台解约 5-用户帐号注销)
     */
    @TableField("contractTerminationMode")
    private String contractTerminationMode;

    /**
     * 签约协议号
     */
    @TableField("requestSerial")
    private String requestSerial;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private Date createDate;
    /**
     *协议状态  0-已签约   1-未签约
     */
    private Integer contractState;
}
