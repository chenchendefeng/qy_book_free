package com.only.tech.dto.admin;

import com.only.tech.entity.admin.RoleEntity;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class UserAdminDto  {

	private Integer id;
	
    private List<RoleDto> roles;
    //所有角色
    private List<RoleEntity> allRoles;
    
    private String loginName;

    private String password;
    private String userName;
    /**
     * 最近登录ip
     */
    private String lastLoginIp;
    /**
     * 最近登录时间
     */
    private Date lastLoginTime;
    private Date dateCreate;
    private Date dateUpdate;
}
