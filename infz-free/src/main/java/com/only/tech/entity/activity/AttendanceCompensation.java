package com.only.tech.entity.activity;

import com.only.tech.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 补签机会
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AttendanceCompensation extends SuperEntity<AttendanceCompensation> {

    private static final long serialVersionUID = 1L;

    @TableField("cuId")
    private Long cuId;

    /**
     * 补签机会
     */
    private Integer times;


}
