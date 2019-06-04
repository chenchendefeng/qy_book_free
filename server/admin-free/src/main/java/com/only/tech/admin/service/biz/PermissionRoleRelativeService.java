package com.only.tech.admin.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.admin.PermissionRoleRelativeEntity;


public interface PermissionRoleRelativeService extends IService<PermissionRoleRelativeEntity>{

	public void deleteByRid(Integer rid);
	
}
