package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_permission_role")
public class PermissionRoleRelativeEntity extends SuperEntityWithIntegerID<PermissionRoleRelativeEntity> {

	private static final long serialVersionUID = 1L;
	
	private Integer rid;
	private Integer pid;
	public PermissionRoleRelativeEntity(Integer rid, Integer pid) {
		super();
		this.rid = rid;
		this.pid = pid;
	}
	public PermissionRoleRelativeEntity() {
		super();
	}
}
