package com.only.tech.admin.service.biz;

import com.only.tech.entity.admin.PermissionRoleRelativeEntity;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.PermissionRoleRelativeEntityMapper;
import com.only.tech.admin.service.biz.PermissionRoleRelativeService;

@Service
public class PermissionRoleRelativeServiceImpl
		extends ServiceImpl<PermissionRoleRelativeEntityMapper, PermissionRoleRelativeEntity>
		implements PermissionRoleRelativeService {

	@Override
	public void deleteByRid(Integer rid) {
		Wrapper<PermissionRoleRelativeEntity> wrapper = new QueryWrapper<PermissionRoleRelativeEntity>().eq("rid", rid);
		super.remove(wrapper);
	}

}
