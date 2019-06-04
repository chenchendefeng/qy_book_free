package com.only.tech.admin.service.biz;

import java.util.List;
import com.only.tech.dto.admin.RoleDto;
import com.only.tech.entity.admin.RoleEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.RoleEntityMapper;
import com.only.tech.admin.service.biz.RoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleEntityMapper, RoleEntity> implements RoleService{

	@Autowired
	RoleEntityMapper roleEntityMapper;
	@Override
	public void deleteRolesById(Integer id) {
		Wrapper<RoleEntity> wrapper = new QueryWrapper<RoleEntity>().eq("id", id).or().eq("parentId", id);
		super.remove(wrapper);	
	}

	@Override
	public RoleDto roleDetail(Integer id) {
		return roleEntityMapper.roleDetail(id);
	}

	@Override
	public List<RoleEntity> getRoleList(String keyword) {
		Wrapper<RoleEntity> wrapper = null;
		if(StringUtils.isNotEmpty(keyword))
		{
			wrapper = new QueryWrapper<RoleEntity>().like("roleName", keyword).or().like("description", keyword);
		}
		return super.list(wrapper);
	}

}
