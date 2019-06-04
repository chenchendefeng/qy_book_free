package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 微信自动续费申请协议
 * </p>
 *
 * @author ZHI
 * @since 2019-01-16
 */
@Data
public class WxAutoRenewaApplicationAgreement extends SuperEntity<WxAutoRenewaApplicationAgreement> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 签约协议号
     */
    @TableField("contractCode")
    private String contractCode;

    /**
     * 委托代扣协议id
     */
    @TableField("contractId")
    private String contractId;

    /**
     * 请求序列号	
     */
    private Long requestSerial;

    /**
     * 状态：0：签约未请求微信；1：签约已请求微信；2：签约微信已返回;3：解约已请求微信；4：解约微信已返回
     */
    private Integer status;

    /**
     * 续费状态（0：未续费；1：已续费）
     */
    @TableField("renewaStatus")
    private Integer renewaStatus;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private Date createDate;

    /**
     * 更新时间
     */
    @TableField("updateDate")
    private Date updateDate;

    /**
     * 解约备注
     */
    @TableField("contractTerminationRemark")
    private String contractTerminationRemark;

    /**
     * 商品id
     */
    @TableField("goodsId")
    private Long goodsId;


}
