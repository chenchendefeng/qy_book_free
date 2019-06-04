package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


import java.util.Date;

/**
 * <p>
 * 用户好友表
 * </p>
 *
 * @author ZHI
 * @since 2019-03-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Friend extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long cuId;

    /**
     * 好友uid
     */
    @TableField("fuId")
    private Long fuId;

    @TableField("createDate")
    private Date createDate;


}
