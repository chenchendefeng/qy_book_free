package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户账户
 * </p>
 *
 * @author zzb
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CustomerAccount extends SuperEntity<CustomerAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 现金
     */
    private Long rmb;

    /**
     * 金币
     */
    private Long gold;

    /**人民币总额*/
    @TableField("rmbTotal")
    private Long rmbTotal;

    /**是否变更(0：未变更；1：已变更）*/
    private Integer changed;

}
