package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_permission")
public class PermissionEntity extends SuperEntityWithIntegerID<PermissionEntity> {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rightName;
	private String url;
	private Integer parentId;
	private String description;
	public PermissionEntity(String rightName, String url, Integer parentId, String description) {
		super();
		this.rightName = rightName;
		this.url = url;
		this.parentId = parentId;
		this.description = description;
	}
	public PermissionEntity() {
		super();
	}
	
}
