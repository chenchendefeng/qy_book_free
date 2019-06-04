package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员记录表
 * </p>
 *
 * @author shoujun.yang
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class VipRecord extends SuperEntity<VipRecord> {

    private static final long serialVersionUID = 1L;

    private Long uid;

    /**
     * 会员类型 1：普通会员 2：续费会员
     */
    @TableField("vipType")
    private Integer vipType;

    /**
     * 会员到期日
     */
    @TableField("vipExpireDate")
    private String vipExpireDate;

    @TableField("createDate")
    private LocalDateTime createDate;

    @TableField("updateDate")
    private LocalDateTime updateDate;


}
