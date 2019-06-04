package com.only.tech.admin.service;

import java.util.List;

import com.only.tech.admin.service.biz.RoleService;
import com.only.tech.entity.admin.RoleEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.only.tech.admin.AdminFreeApplicationTests;

public class RoleServiceTest extends AdminFreeApplicationTests {
	@Autowired
    RoleService roleService;
	
	@Test
	public void roleList()
	{
		String keyword="";
		List<RoleEntity> roleList = roleService.getRoleList(keyword);
		
		keyword="12121";
		roleList = roleService.getRoleList(keyword);
	}
}
