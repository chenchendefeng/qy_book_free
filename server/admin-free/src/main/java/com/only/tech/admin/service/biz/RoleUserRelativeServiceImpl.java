package com.only.tech.admin.service.biz;

import com.only.tech.entity.admin.RoleUserRelativeEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.RoleUserRelativeEntityMapper;
import com.only.tech.admin.service.biz.RoleUserRelativeService;

@Service
public class RoleUserRelativeServiceImpl
		extends ServiceImpl<RoleUserRelativeEntityMapper, RoleUserRelativeEntity>
		implements RoleUserRelativeService {

	@Override
	public void deleteByUid(Integer uid) {
		Wrapper<RoleUserRelativeEntity> wrapper = new QueryWrapper<RoleUserRelativeEntity>().eq("uid", uid);
		super.remove(wrapper);
	}

}
