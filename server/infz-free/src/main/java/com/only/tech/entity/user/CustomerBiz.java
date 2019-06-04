package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import com.only.tech.entity.book.BookSubject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类：用户业务信息
 *
 * @author shutong
 * @date 2019/05/15
 */
@Data
@ApiModel
public class CustomerBiz extends SuperEntity<CustomerBiz> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("用户id")
	private Long cuId;

	@ApiModelProperty("看视频免广告-结束时间")
	private Date freeAdvTime;


}