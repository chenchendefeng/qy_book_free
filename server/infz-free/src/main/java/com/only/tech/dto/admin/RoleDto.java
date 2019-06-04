package com.only.tech.dto.admin;

import com.only.tech.entity.admin.PermissionEntity;
import lombok.Data;

import java.util.Set;

@Data
public class RoleDto{
	private Integer id;
	private String roleName;
	private Integer parentId;
	private String description;
    private Set<PermissionDto> permissions;
    
    private Set<PermissionEntity> allPermissions;

    private Set<UserAdminDto> users;
}
