package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_user_role")
public class RoleUserRelativeEntity extends SuperEntityWithIntegerID<RoleUserRelativeEntity> {

	private static final long serialVersionUID = 1L;
	
	private Integer rid;
	private Integer uid;
	public RoleUserRelativeEntity(Integer rid, Integer uid) {
		super();
		this.rid = rid;
		this.uid = uid;
	}
	public RoleUserRelativeEntity() {
		super();
	}
}
