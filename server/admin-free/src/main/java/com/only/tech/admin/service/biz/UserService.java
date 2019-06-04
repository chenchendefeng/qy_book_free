package com.only.tech.admin.service.biz;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.UserEntity;


public interface UserService extends IService<UserEntity>{

	UserEntity findByLoginName(String loginName);
	
	UserAdminDto findUserInfoByLoginName(String loginName);
	
	boolean isLoginNameExist(String loginName);
	
	public void updatePassword(Map<String,Object> map);

	public UserAdminDto userDetail(Integer id);

	public List<UserAdminDto> listUserByUserName(String userName);
}
