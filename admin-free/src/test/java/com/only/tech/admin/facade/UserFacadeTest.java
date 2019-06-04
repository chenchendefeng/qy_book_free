package com.only.tech.admin.facade;

import com.only.tech.admin.AdminFreeApplicationTests;
import com.only.tech.admin.service.facade.UserFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class UserFacadeTest extends AdminFreeApplicationTests {

	@Autowired
	UserFacade UserFacade;
	@Autowired
    com.only.tech.admin.service.biz.UserService UserService;
	
	@Test
	public void testUpdatePassword()
	{
		UserEntity ue = new UserEntity();
		String userName = "wangchongyang5";
		ue.setLoginName(userName);
		ue.setPassword("123456");
		ue.setUserName(userName);
		String rids ="1,2";
		UserFacade.saveUser(ue, rids);
		ResultDto listUsers = UserFacade.listUsers(new PageReq(),userName);
		PageData pa =(PageData) listUsers.getData();
		List<UserEntity> lus=pa.getData();
		for (UserEntity userEntity : lus) {
			System.out.println(lus);
		}
		ue=lus.get(0);
		rids="1";
		UserFacade.updateUser(ue, rids);
		
		UserAdminDto userDetail = UserFacade.userDetail(ue.getId());
		System.out.println(userDetail);
	}
}
