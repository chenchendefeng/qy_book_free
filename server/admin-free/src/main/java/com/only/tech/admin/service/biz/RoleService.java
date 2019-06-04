package com.only.tech.admin.service.biz;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.admin.RoleDto;
import com.only.tech.entity.admin.RoleEntity;


public interface RoleService extends IService<RoleEntity>{
	
	/**
	 * 删除表数据，parentID or id
	 * @param id
	 */
	public void deleteRolesById(Integer id);

	public RoleDto roleDetail(Integer id);
	
	public List<RoleEntity> getRoleList(String keyword);
	
}
