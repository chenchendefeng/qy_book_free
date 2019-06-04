package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 查询红包结果
 * </p>
 *
 * @author zzb
 * @since 2019-05-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RedpacketCheckResult extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 通信状态(SUCCESS | FAIL）
     */
    @TableField("returnCode")
    private String returnCode;

    /**
     * 信息
     */
    @TableField("returnMsg")
    private String returnMsg;

    /**
     * 结果（SUCCESS/FAIL）
     */
    @TableField("resultCode")
    private String resultCode;

    /**
     * 错误代码
     */
    @TableField("errCode")
    private String errCode;

    /**
     * 错误代码描述
     */
    @TableField("errCodeDes")
    private String errCodeDes;

    /**
     * 商户订单号
     */
    @TableField("mchBillno")
    private String mchBillno;

    /**
     * 商户号
     */
    @TableField("mchId")
    private String mchId;

    /**
     * 红包单号
     */
    @TableField("detailId")
    private String detailId;

    /**
     * SENDING:发放中 | SENT:已发放待领取 | FAILED：发放失败 | RECEIVED:已领取  | RFUND_ING:退款中 | REFUND:已退款
     */
    @TableField("status")
    private String status;

    /**
     * 发放类型(API:通过API接口发放 | UPLOAD:通过上传文件方式发放 | ACTIVITY:通过活动方式发放)
     */
    @TableField("sendType")
    private String sendType;

    /**
     * 红包类型  (GROUP:裂变红包 | NORMAL:普通红包)
     */
    @TableField("hbType")
    private String hbType;

    /**
     * 红包个数
     */
    @TableField("totalNum")
    private Integer totalNum;

    /**
     * 红包金额
     */
    @TableField("totalAmount")
    private Integer totalAmount;

    /**
     * 失败原因
     */
    @TableField("reason")
    private String reason;

    /**
     * 红包发送时间
     */
    @TableField("sendTime")
    private String sendTime;

    /**
     * 红包退款时间
     */
    @TableField("refundTime")
    private String refundTime;

    /**
     * 红包退款金额
     */
    @TableField("refundAmount")
    private Integer refundAmount;

    /**
     * 祝福语
     */
    private String wishing;

    /**
     * 活动描述
     */
    private String remark;

    /**
     * 活动名称
     */
    @TableField("actName")
    private String actName;

    /**
     * 裂变红包领取列表
     */
    @TableField(exist = false)
    private List<Map<String,Object>> hblist;


}