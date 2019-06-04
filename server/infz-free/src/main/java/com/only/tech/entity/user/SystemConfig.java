package com.only.tech.entity.user;

import com.only.tech.base.SuperEntity;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统配置
 * </p>
 *
 * @author zzb
 * @since 2019-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SystemConfig extends SuperEntityWithIntegerID {

    private static final long serialVersionUID = 1L;

    /**
     * 类型（exchangeRatio:兑换比例）
     */
    private String type;

    /**
     * 数值1
     * 若是人民币单位是分
     */
    private Integer number1;

    /**
     * 数值2
     */
    private Integer number2;


}
