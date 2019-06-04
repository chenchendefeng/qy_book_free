package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_group")
public class GroupEntity extends SuperEntityWithIntegerID<GroupEntity> {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupName;
	private Integer parentId;
	private String description;
}
