package com.only.tech.admin.mapper;

import java.util.List;
import java.util.Map;

import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.UserEntity;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserEntityMapper extends BaseMapper<UserEntity> {
	
	UserAdminDto findUserInfoByLoginName(String loginName);
	
	UserAdminDto userDetail(Integer id);
	
	public void updatePassword(Map<String,Object> map);
	
	public List<UserAdminDto> listUserByUserName(@Param(value="userName")String userName);
}
