package com.only.tech.admin.service;

import java.util.Set;

import com.only.tech.admin.service.biz.PermissionService;
import com.only.tech.dto.admin.PermissionDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.only.tech.admin.AdminFreeApplicationTests;

public class PermissionServiceTest extends AdminFreeApplicationTests {
	@Autowired
    PermissionService permissionService;
	
	@Test
	public void permissionList()
	{
		String keyword="";
		Set<PermissionDto> permissionList = permissionService.getPermissionList(keyword);
		System.out.println(permissionList);
		keyword="操作";
		permissionList = permissionService.getPermissionList(keyword);
		System.out.println(permissionList);
	}
}
