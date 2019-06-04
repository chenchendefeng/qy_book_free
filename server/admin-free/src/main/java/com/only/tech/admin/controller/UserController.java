package com.only.tech.admin.controller;

import com.only.tech.admin.common.helper.PasswordHelper;
import com.only.tech.admin.service.biz.PermissionService;
import com.only.tech.admin.service.biz.RoleService;
import com.only.tech.admin.service.biz.UserService;
import com.only.tech.admin.service.facade.PermissionFacade;
import com.only.tech.admin.service.facade.RoleFacade;
import com.only.tech.admin.service.facade.UserFacade;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.PermissionEntity;
import com.only.tech.entity.admin.RoleEntity;
import com.only.tech.entity.admin.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "admin")
@Api(tags="用户管理")
@Slf4j
public class UserController  {
 
	@Autowired
	private UserService userService;
	@Autowired
	private UserFacade userFacade;
	@Autowired
	private RoleFacade roleFacade;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PermissionFacade permissionFacade;
	@Autowired
	private RoleService roleService;
	@ApiOperation(value = "addUser", notes = "添加用户")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "loginName", dataType = "String", value = "登录账户", required = true),
		@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", value = "密码", required = true),
		@ApiImplicitParam(paramType = "query", name = "rids", dataType = "String", value = "rids", required = true),
		@ApiImplicitParam(paramType = "query", name = "userName", dataType = "String", value = "用户名", required = true)
	})
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResultDto addUser(@RequestParam(name = "loginName", required = true) String loginName,
							 @RequestParam(name = "password", required = true) String password,
							 @RequestParam(name = "userName", required = true) String userName,
							 @RequestParam(name = "rids", required = false) String rids) {
		try {
			if(userService.isLoginNameExist(loginName))
			{
				log.error("该用户名已经被注册,loginName={}",loginName);
				return ResultDto.errorResult("该用户名已经被注册");
			}
			UserEntity user = new UserEntity();
			PasswordHelper.fillUser(loginName, password, userName,user);
			userFacade.saveUser(user, rids);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("addUser error,loginName={}",loginName,e);
			return ResultDto.errorResult();
		}
	}
	
	@ApiOperation(value = "deleteUser", notes = "删除用户")
	@RequestMapping(value = "/deleteUsers/{ids}", method = RequestMethod.POST)
	public ResultDto deleteUsers(@PathVariable String ids)
	{
		try {
			userService.removeByIds(Arrays.asList(ids.split(",")));
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("deleteUsers error,ids={}",ids,e);
			return ResultDto.errorResult();
		}
	}
	
	@ApiOperation(value = "getUsers", notes = "查找用户")
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	public ResultDto getUserListByPage(PageReq pageReq, @RequestParam(name = "userName", required = false) String userName){
		return userFacade.listUsers(pageReq,userName);
	}
	
	@ApiOperation(value = "userDetail", notes = "用户详情")
	@RequestMapping(value = "/userDetail/{id}", method = RequestMethod.POST)
	public ResultDto userDetail(@PathVariable Integer id){
		try {
			UserAdminDto ud = userFacade.userDetail(id);
			return ResultDto.succesResult(ud);
		} catch (Exception e) {
			log.error("userDetail error,id={}",id,e);
			return ResultDto.errorResult();
		}
	}

	
	@ApiOperation(value = "updateUser", notes = "更新用户，如角色、用户信息")
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	public ResultDto updateUser(@RequestParam(name = "loginName", required = true) String loginName,
			@RequestParam(name = "userName", required = true) String userName,
			Integer id,
			@RequestParam(name = "rids", required = false) String rids){
		try {
			UserEntity ue= new UserEntity();
			ue.setId(id);
			PasswordHelper.fillUser(loginName, null, userName,ue);
			userFacade.updateUser(ue, rids);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("update user error,loginName={}",loginName,e);
			return ResultDto.errorResult();
		}
	}
	
	@ApiOperation(value = "roleDetail", notes = "角色详情")
	@RequestMapping(value = "/roleDetail/{id}", method = RequestMethod.POST)
	public ResultDto roleDetail(@PathVariable(name = "id", required = true) Integer id){
		try {
			return ResultDto.succesResult(roleFacade.roleDetail(id));
		} catch (Exception e) {
			log.error("roleDetail error,id={}",id,e);
			return ResultDto.errorResult();
		}
	}	
	@ApiOperation(value = "deleteRole", notes = "删除角色")
	@RequestMapping(value = "/deleteRole/{ids}", method = RequestMethod.POST)
	public ResultDto deleteRole(@PathVariable String ids)
	{
		try {
			roleFacade.deleteRoles(ids);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("deleteRole error,id={}",ids,e);
			return ResultDto.errorResult();
		}
	}

	@ApiOperation(value = "addRole", notes = "添加角色")
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public ResultDto addRole(@RequestParam(name = "roleName", required = true) String roleName,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "parentId", required = false) Integer parentId,
			@RequestParam(name = "pids", required = false)String pids) {
		try {
			if(StringUtils.isEmpty(roleName) || roleName.length()>64)
			{
				log.info("addRole param error,roleName={}",roleName);
				return ResultDto.errorResult();
			}
			if(StringUtils.isNotEmpty(description) && description.length()>200)
			{
				log.info("addRole param error,description={}",description);
				return ResultDto.errorResult();
			}
			RoleEntity role = new RoleEntity(roleName, parentId, description);
			roleFacade.saveRole(role, pids);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("addUser error.roleName={}",roleName, e);
			return ResultDto.errorResult();
		}
	}
	
	@ApiOperation(value = "updateRole", notes = "更新角色")
	@RequestMapping(value = "/updateRole/{id}", method = RequestMethod.POST)
	public ResultDto updateRole(@RequestParam(name = "roleName", required = true) String roleName,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "parentId", required = false) Integer parentId,
			@PathVariable Integer id,
			@RequestParam(name = "pids", required = false)String pids) {
		try {
			if(StringUtils.isEmpty(roleName) || roleName.length()>64)
			{
				log.info("updateRole param error,id={},roleName={}",id,roleName);
				return ResultDto.errorResult();
			}
			if(StringUtils.isNotEmpty(description) && description.length()>200)
			{
				log.info("updateRole param error,id={},description={}",id,description);
				return ResultDto.errorResult();
			}
			RoleEntity role = new RoleEntity(roleName, parentId, description);
			role.setId(id);
			roleFacade.updateRole(role, pids);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("updateRole error,id={}",id, e);
			return ResultDto.errorResult();
		}
	}
	
	@ApiOperation(value = "addPermission", notes = "添加权限")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "rightName", dataType = "String", value = "权限名称", required = true),
		@ApiImplicitParam(paramType = "query", name = "url", dataType = "String", value = "url", required = false),
		@ApiImplicitParam(paramType = "query", name = "description", dataType = "String", value = "描述", required = false),
		@ApiImplicitParam(paramType = "query", name = "parentId", dataType = "int", value = "父类id", required = false)
	})
	@RequestMapping(value = "/addPermission", method = RequestMethod.POST)
	public ResultDto addPermission(@RequestParam(name = "rightName", required = true) String rightName,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "url", required = false) String url,
			@RequestParam(name = "parentId", required = false) Integer parentId) {
		try {
			if(StringUtils.isEmpty(rightName) || rightName.length()>64)
			{
				log.info("addRole param error,rightName={}",rightName);
				return ResultDto.errorResult();
			}
			if(StringUtils.isNotEmpty(url) && url.length()>255)
			{
				log.info("addRole param error,url={}",url);
				return ResultDto.errorResult();
			}
			if(StringUtils.isNotEmpty(description) && description.length()>200)
			{
				log.info("addRole param error,description={}",description);
				return ResultDto.errorResult();
			}
			PermissionEntity permission = new PermissionEntity(rightName, url, parentId, description);
			permissionService.save(permission);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("addPermission error,rightName={}",rightName, e);
			return ResultDto.errorResult();
		}
	}
	@ApiOperation(value = "deletePermission", notes = "删除权限")
	@RequestMapping(value = "/deletePermission/{ids}", method = RequestMethod.POST)
	public ResultDto deletePermission(@PathVariable(name = "ids",required = true)String ids)
	{
		try {
			permissionFacade.deletePermission(ids);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("deletePermission error,ids={}",ids,e);
			return ResultDto.errorResult();
		}
	}
	
	@ApiOperation(value = "permissionDetail", notes = "权限详情")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "permissionDetail", name = "id", dataType = "int", value = "id", required = true)
	})
	@RequestMapping(value = "/permissionDetail/{id}", method = RequestMethod.POST)
	public ResultDto permissionDetail( Integer id){
		try {
			return ResultDto.succesResult(permissionService.getPermissionDetail(id));
		} catch (Exception e) {
			log.error("roleDetail error,id={}",id,e);
			return ResultDto.errorResult();
		}
	}	
	
	@ApiOperation(value = "updatePassword", notes = "修改密码")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "id", required = true),
			@ApiImplicitParam(paramType = "query", name = "oPwd", dataType = "int", value = "原密码", required = true),
			@ApiImplicitParam(paramType = "query", name = "nPwd", dataType = "int", value = "新密码", required = true),
	})
	@RequestMapping(value = "/updatePassword/{id}", method = RequestMethod.POST)
	public ResultDto updatePassword(Integer id,String oPwd,String nPwd){
		try {
			boolean update = userFacade.updatePassword(id, oPwd,nPwd);
			return  update ? ResultDto.succesResult("修改成功") : ResultDto.errorResult("修改失败");
		} catch (Exception e) {
			log.error("updatePassword error,id={}",id,e);
			return ResultDto.errorResult("修改失败");
		}
	}	
	
	
	@ApiOperation(value = "permissionList", notes = "权限列表")
	@RequestMapping(value = "/permissionList", method = RequestMethod.POST)
	public ResultDto permissionList(@RequestParam(name = "keyword", required = false) String keyword){
		return ResultDto.succesResult(permissionService.getPermissionList(keyword));
	}	
	
	@ApiOperation(value = "roleList", notes = "角色列表")
	@RequestMapping(value = "/roleList", method = RequestMethod.POST)
	public ResultDto roleList(@RequestParam(name = "keyword", required = false) String keyword){
		return ResultDto.succesResult(roleService.getRoleList(keyword));
	}	
	
	
	
}
