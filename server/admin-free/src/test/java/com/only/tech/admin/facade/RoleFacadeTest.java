package com.only.tech.admin.facade;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.only.tech.admin.AdminFreeApplicationTests;
import com.only.tech.admin.service.facade.RoleFacade;

public class RoleFacadeTest extends AdminFreeApplicationTests {

	@Autowired
	RoleFacade faca;
	
	@Test
	public void roleDetatil()
	{
		System.out.println(faca.roleDetail(1));
	}
}
