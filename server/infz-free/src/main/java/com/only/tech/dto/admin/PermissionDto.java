package com.only.tech.dto.admin;

import lombok.Data;

import java.util.Set;

@Data
	public class PermissionDto{
	private Integer id;
	private String rightName;
	private String url;
	private Integer parentId;
	private String description;
	private Set<RoleDto> roles;
	private Set<PermissionDto> kids;
	
}
