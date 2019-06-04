package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ALog extends SuperEntityWithIntegerID<ALog> {

    private static final long serialVersionUID = 1L;

    /**
     * 操作人id
     */
    @TableField("adminId")
    private Integer adminId;

    /**
     * 操作账户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 操作类型 0-新增 1-删除 2-更新
     */
    @TableField("handleType")
    private Integer handleType;

    /**
     * 操作表名
     */
    @TableField("tableName")
    private String tableName;

    /**
     * 操作表id
     */
    @TableField("tableId")
    private String tableId;

    private String description;
    /**
     * 操作内容
     */
    private String handleContent;
    private String loginIp;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
}
