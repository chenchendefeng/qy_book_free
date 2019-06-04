package com.only.tech.admin.mapper;

import java.util.List;

import com.only.tech.dto.admin.PermissionDto;
import com.only.tech.entity.admin.PermissionEntity;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface PermissionEntityMapper extends BaseMapper<PermissionEntity>{
	PermissionDto getPermissionDetail(Integer id);
	
	List<PermissionDto> getPermissionList(@Param(value="keyword")String keyword);
}
