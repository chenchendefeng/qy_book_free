package com.only.tech.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.admin.RoleDto;
import com.only.tech.entity.admin.RoleEntity;

public interface RoleEntityMapper extends BaseMapper<RoleEntity>{

	RoleDto roleDetail(Integer id);

}
