package com.only.tech.entity.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 签到
 * </p>
 *
 * @author zzb
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Attendance extends SuperEntity<Attendance> {

    private static final long serialVersionUID = 1L;

    @TableField("cuId")
    private Long cuId;

    /**
     * 类型（0:首签；1:签到；2：补签)
     */
    private Integer type;

    /**
     * 日期
     */
    @TableField("attendanceDate")
    private String attendanceDate;

    /**
     * 连续次数
     */
    private Integer times;

    /**
     * 创建日期
     */
    @TableField("createTime")
    private Date createTime;


}
