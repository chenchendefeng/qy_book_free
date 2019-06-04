package com.only.tech.admin.service.biz;

import java.util.List;
import java.util.Map;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.UserEntityMapper;
import com.only.tech.admin.service.biz.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserEntityMapper, UserEntity> implements UserService{
	
	@Autowired
	UserEntityMapper userMapper;
	
	@Override
	public UserEntity findByLoginName(String loginName) {
		Wrapper<UserEntity> wrapper = new QueryWrapper<UserEntity>().eq("loginName", loginName);
		return super.getOne(wrapper);
	}

	@Override
	public UserAdminDto findUserInfoByLoginName(String loginName) {
		return userMapper.findUserInfoByLoginName(loginName);
	}
	
	@Override
	public boolean isLoginNameExist(String loginName) {
		Wrapper<UserEntity> wrapper = new QueryWrapper<UserEntity>().eq("loginName", loginName);
		return super.count(wrapper)>0;
	}

	@Override
	public UserAdminDto userDetail(Integer id) {
		return userMapper.userDetail(id);
	}

	@Override
	public void updatePassword(Map<String,Object> map) {
		userMapper.updatePassword(map);
	}

	@Override
	public List<UserAdminDto> listUserByUserName(String userName) {
		return userMapper.listUserByUserName(userName);
	}

}
