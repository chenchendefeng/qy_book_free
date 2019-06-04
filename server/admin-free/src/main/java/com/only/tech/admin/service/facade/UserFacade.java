package com.only.tech.admin.service.facade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.admin.service.biz.RoleService;
import com.only.tech.admin.service.biz.RoleUserRelativeService;
import com.only.tech.admin.service.biz.UserService;
import com.only.tech.admin.common.targetMethod.HandleType;
import com.only.tech.admin.common.targetMethod.RecordLog;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.RoleUserRelativeEntity;
import com.only.tech.entity.admin.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserFacade {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleUserRelativeService roleUserRelativeService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 添加用户
	 * @param ue
	 * @param rids
	 */
	@Transactional
	@RecordLog(handleType = HandleType.ADD, descript = "添加用户",tableName="a_user")
	public Integer saveUser(UserEntity ue, String rids)
	{
		ue.setDateCreate(new Date());
		userService.save(ue);
		Integer uid = ue.getId();
		if(StringUtils.isEmpty(rids))
		{
			return uid;
		}
		String[] ridsStr = rids.split(",");
		for(String rid:ridsStr)
		{
			roleUserRelativeService.save(new RoleUserRelativeEntity(Integer.parseInt(rid) ,uid));
		}
		return uid;
	}
	
	/**
	 * 更新某个用户的角色信息、用户信息
	 * @param ue
	 * @param rids
	 */
	@Transactional
	@RecordLog(handleType = HandleType.UPDATE, descript = "修改用户信息",tableName="a_user")
	public Integer updateUser(UserEntity ue,String rids)
	{
		ue.setDateUpdate(new Date());
		userService.updateById(ue);
		Integer uid = ue.getId();
		roleUserRelativeService.deleteByUid(uid);
		if(StringUtils.isEmpty(rids))
		{
			return uid;
		}
		String[] ridsStr = rids.split(",");
		for(String rid:ridsStr)
		{
			roleUserRelativeService.save(new RoleUserRelativeEntity(Integer.parseInt(rid) ,uid));
		}
		return uid;
	}
	
	public ResultDto listUsers(PageReq pageReq, String userName)
	{
		try {
			Page<UserAdminDto> page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
			userService.listUserByUserName(userName);
			PageData pageData = new PageData(page);
			
			return ResultDto.succesResult(pageData);
		} catch (Exception e) {
			log.error("listUsers error,userName={}",userName,e);
			return ResultDto.errorResult();
		}
	}
	
	@RecordLog(handleType = HandleType.UPDATE, descript = "修改用户密码",tableName="a_user")
	public boolean updatePassword(Integer id, String oPwd, String nPwd)
	{
		//校验原密码
		String oPd = DigestUtils.md5DigestAsHex(oPwd.getBytes());
		Wrapper qw = new QueryWrapper<>().eq("id",id).eq("password",oPd);
		UserEntity userEntity = userService.getOne(qw);
		if (userEntity == null){
			return false;
		}

		//更新密码
		String password = DigestUtils.md5DigestAsHex(nPwd.getBytes());
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		userService.updatePassword(map);
		return true;
	}
	

	public UserAdminDto userDetail(Integer id) {
		UserAdminDto ud = userService.userDetail(id);
		if(null != ud)
		{
			ud.setAllRoles(roleService.list(null));
		}
		return ud;
	}

}
