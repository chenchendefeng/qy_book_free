package com.only.tech.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.only.tech.admin.service.biz.UserService;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.admin.AdminFreeApplicationTests;

public class UserServiceTest extends AdminFreeApplicationTests {

	@Autowired
    UserService service;
	
//	@Test
	public void testDelete()
	{
		List<Integer> idList = new ArrayList<>();
		idList.add(3);
		idList.add(4);
		Integer[] s ={5,2};
		service.removeByIds(Arrays.asList(s));
	}
	
//	@Test
	public void testFindByloginName()
	{
		String loginName="zhang";
		Wrapper<UserEntity> wrapper = new QueryWrapper<UserEntity>().like("userName", loginName);
		List<UserEntity> list=service.list(wrapper);
		System.out.println(list);
		String loginName1="zhang11";
		Wrapper<UserEntity> wrapper2 = new QueryWrapper<UserEntity>().like("userName", loginName1);
		List<UserEntity> list2=service.list(wrapper2);
		System.out.println(list2);
		UserAdminDto u=service.userDetail(1);
	}
	
	@Test
	public void testlogin()
	{
		String username="admin";
		UserAdminDto user = service.findUserInfoByLoginName(username);
		 System.out.println(user);
	}
}
