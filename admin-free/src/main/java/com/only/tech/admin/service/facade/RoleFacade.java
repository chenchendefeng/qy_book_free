package com.only.tech.admin.service.facade;

import java.util.HashSet;

import com.only.tech.dto.admin.RoleDto;
import com.only.tech.entity.admin.PermissionRoleRelativeEntity;
import com.only.tech.entity.admin.RoleEntity;
import com.only.tech.entity.admin.RoleUserRelativeEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.admin.service.biz.PermissionRoleRelativeService;
import com.only.tech.admin.service.biz.PermissionService;
import com.only.tech.admin.service.biz.RoleService;
import com.only.tech.admin.service.biz.RoleUserRelativeService;
import com.only.tech.admin.common.targetMethod.HandleType;
import com.only.tech.admin.common.targetMethod.RecordLog;

@Service
public class RoleFacade {
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleUserRelativeService roleUserRelativeService;
	@Autowired
	private PermissionRoleRelativeService permissionRoleRelativeService;
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 删除某个角色，并把它的权限删除
	 * @param ids
	 */
	@Transactional
	@RecordLog(handleType = HandleType.DELETE, descript = "批量删除角色",tableName="a_role")
	public String deleteRoles(String ids)
	{
		if(StringUtils.isEmpty(ids))
		{
			return ids;
		}
		String[] idStrs = ids.split(",");
		for(String id: idStrs)
		{
			roleService.deleteRolesById(Integer.parseInt(id));
			Wrapper<RoleUserRelativeEntity> wrapper = new QueryWrapper<RoleUserRelativeEntity>().eq("rid", id);
			roleUserRelativeService.remove(wrapper);
		}
		return ids;
	}

	/**
	 * 更新某个角色的权限
	 * @param re
	 * @param pids
	 * @return
	 */
	@Transactional
	@RecordLog(handleType = HandleType.UPDATE, descript = "更新角色的权限",tableName="a_role")
	public Integer updateRole(RoleEntity re , String pids)
	{
		roleService.updateById(re);
		Integer rid = re.getId();
		permissionRoleRelativeService.deleteByRid(rid);
		if(StringUtils.isEmpty(pids))
		{
			return rid;
		}
		String[] pidsStr = pids.split(",");
		for(String pid:pidsStr)
		{
			permissionRoleRelativeService.save(new PermissionRoleRelativeEntity(rid ,Integer.parseInt(pid)));
		}
		return rid;
	}
	
	/**
	 * 添加角色
	 * @param ue
	 * @param rids
	 */
	@Transactional
	@RecordLog(handleType = HandleType.ADD, descript = "添加角色",tableName="a_role")
	public RoleEntity saveRole(RoleEntity re ,String pids)
	{
		roleService.save(re);
		Integer rid = re.getId();
		if(StringUtils.isEmpty(pids))
		{
			return re;
		}
		String[] pidsStr = pids.split(",");
		for(String pid: pidsStr)
		{
			permissionRoleRelativeService.save(new PermissionRoleRelativeEntity(rid ,Integer.parseInt(pid)));
		}
		return re;
	}
	public RoleDto roleDetail(Integer id)
	{
		RoleDto user= roleService.roleDetail(id);
		if(user != null)
		{
			user.setAllPermissions(new HashSet<>(permissionService.list(null)));
		}
		return user;
	}
	
	
}
