package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 充币流水表
 * @author Lenovo
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("p_add_bill_record")
public class AddBillRecord extends SuperEntity<AddBillRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 书币
     */
    @TableField("bookMoney")
    private Long bookMoney;
    
    /**
     * 赠送书币
     */
    @TableField("bookBonus")
    private Long bookBonus;
    
    /**
     * 金额
     */
    @TableField("money")
    private Integer money;
    @TableField("orderNum")
    private String orderNum;
    /**
     * 充币状态 0-充币失败 1-充币成功
     */
    @TableField("addBillStatus")
    private Integer addBillStatus;
    private Long readCardId;
    
    @TableField("u_id")
    private Long uid;
    
    @TableField("create_date")
    private Date createTime;

    @TableField("update_date")
    private Date updateTime;
    
    private String systemType;
    private Long vipCardId;
}
