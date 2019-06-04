package com.only.tech.admin.common.helper;

import com.only.tech.entity.admin.UserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.DigestUtils;

public class PasswordHelper {
	
	/**
	 * 处理登录密码、校验参数
	 * @param loginName
	 * @param password
	 * @param userName
	 * @return
	 * @throws Exception 
	 */
	public static void fillUser(String loginName,String password,String userName,UserEntity user) throws Exception
	{
		if(StringUtils.isEmpty(loginName)||loginName.length()>64)
		{
			throw new Exception("param [loginName] error ,loginName="+loginName);
		}
		if(StringUtils.isEmpty(userName)||userName.length()>64)
		{
			throw new Exception("param [loginName] error ,loginName="+loginName);
		}
		user.setLoginName(loginName);
		user.setUserName(userName);
		if(null != password)
		{
			user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		}
	}
}
