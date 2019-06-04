package com.only.tech.entity.user;

import java.time.LocalDateTime;
import java.util.Date;

import com.only.tech.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 上线记录
 * </p>
 *
 * @author zzb
 * @since 2019-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class OnlineRecord extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @TableField("cuId")
    private Long cuId;

    private Date uptime;


}
