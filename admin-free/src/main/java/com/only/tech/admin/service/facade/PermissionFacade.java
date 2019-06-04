package com.only.tech.admin.service.facade;

import java.util.List;

import com.only.tech.entity.admin.PermissionRoleRelativeEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.only.tech.admin.service.biz.PermissionRoleRelativeService;
import com.only.tech.admin.service.biz.PermissionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PermissionFacade {
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PermissionRoleRelativeService permissionRoleRelativeService;
	
	@Transactional
	public void deletePermission(String ids)
	{
		if(StringUtils.isEmpty(ids))
		{
			return ;
		}
		String[] pids = ids.split(",");
		for(String idStr:pids)
		{
			Integer id = Integer.parseInt(idStr);
			permissionService.removeById(id);
			Wrapper<PermissionRoleRelativeEntity> wrapper = new QueryWrapper<PermissionRoleRelativeEntity>().eq("pid", id);
			permissionRoleRelativeService.remove(wrapper);
		}
	}
	
	@Transactional
	public void addPermission(List<Integer> ids)
	{
		if(CollectionUtils.isEmpty(ids))
		{
			return ;
		}
		for(Integer id:ids)
		{
			permissionService.removeById(id);
			Wrapper<PermissionRoleRelativeEntity> wrapper = new QueryWrapper<PermissionRoleRelativeEntity>().eq("pid", id);
			permissionRoleRelativeService.remove(wrapper);
		}
	}
	
	
}
