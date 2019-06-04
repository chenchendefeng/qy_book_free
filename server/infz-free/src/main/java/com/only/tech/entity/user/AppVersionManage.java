package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * app版本管理
 * </p>
 *
 * @author ZHI ZUN BAO
 * @since 2019-01-03
 */
@Data
@TableName("app_version_manage")
public class AppVersionManage extends SuperEntityWithIntegerID<AppVersionManage> {

    private static final long serialVersionUID = 1L;

    /**
     * 版本号
     */
    private String version;

    @TableField("versionCode")
    private Integer versionCode;

    /**
     * 审核状态（0:未审核；1：已审核）
     */
    private Integer audit;

    /**
     * 是否启用（0：未启用；1：启用）
     */
    private Integer enable;

    /**
     * 客户端类型（IOS;Android）
     */
    @TableField("clientType")
    private String clientType;

    /**
     * 创建日期
     */
    @TableField("createDate")
    private Date createDate;

    /**
     * 最低版本
     */
    @TableField("miniVersion")
    private String miniVersion;

    /**
     * 最低版本
     */
    @TableField("miniVersionCode")
    private Integer miniVersionCode;

    /**
     * 下载路径
     */
    @TableField("downloadUrl")
    private String downloadUrl;

    /**
     * 描述
     */
    private String des;

    @TableField("updateDate")
    private Date updateDate;

    /**
     * 主题
     */
    private String title;

    /**
     * 提示间隔时间
     */
    private Integer intervalTime;

}
