package com.only.tech.admin.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.admin.RoleUserRelativeEntity;


public interface RoleUserRelativeService extends IService<RoleUserRelativeEntity>{

	public void deleteByUid(Integer uid);
	
}
