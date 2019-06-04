package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_role")
public class RoleEntity extends SuperEntityWithIntegerID<RoleEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleName;
	private Integer parentId;
	private String description;
	
	public RoleEntity()
	{
		super();
	}
	public RoleEntity(String roleName,Integer parentId,String description)
	{
		super();
		this.roleName=roleName;
		this.parentId=parentId;
		this.description=description;
	}
}
