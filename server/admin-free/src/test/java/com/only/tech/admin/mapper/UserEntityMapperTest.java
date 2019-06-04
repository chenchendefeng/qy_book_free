package com.only.tech.admin.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.only.tech.admin.AdminFreeApplicationTests;

public class UserEntityMapperTest extends AdminFreeApplicationTests {
	@Autowired
	UserEntityMapper UserEntityMapper;
	@Test
	public void testquery(){
////		System.out.println(UserEntityMapper.listUserByUserName(null));
//		System.out.println("****************************");
////		System.out.println(UserEntityMapper.listUserByUserName(""));
//		System.out.println("****************************");
//		System.out.println(UserEntityMapper.listUserByUserName("d"));
		System.out.println(UserEntityMapper.findUserInfoByLoginName("d"));
	}
}
