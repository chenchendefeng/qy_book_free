package com.only.tech.admin.service.biz;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.admin.PermissionDto;
import com.only.tech.entity.admin.PermissionEntity;


public interface PermissionService extends IService<PermissionEntity>{

	public PermissionDto getPermissionDetail(Integer id);
	
	public Set<PermissionDto> getPermissionList(String keyword);
	
}
