package com.only.tech.entity.book;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 书籍阅读进度表
 * </p>
 *
 * @author zzb
 * @since 2019-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("read_process")
public class ReadProcess extends SuperEntity<ReadProcess> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 书籍id
     */
    private Long bid;

    /**
     * 章节id
     */
    private Long cid;

    /**
     * 阅读了多少字
     */
    @TableField("readWords")
    private Integer readWords;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;

    @ApiModelProperty("阅读进度（ '20.5' 表示进度为：20.5% ）")
    private Float process;


}
