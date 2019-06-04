package com.only.tech.admin.service.biz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.only.tech.dto.admin.PermissionDto;
import com.only.tech.entity.admin.PermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.PermissionEntityMapper;
import com.only.tech.admin.service.biz.PermissionService;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionEntityMapper, PermissionEntity> implements PermissionService{

	@Autowired
	PermissionEntityMapper permissionMapper;
	
	@Override
	public PermissionDto getPermissionDetail(Integer id) {
		return permissionMapper.getPermissionDetail(id);
	}

	@Override
	public Set<PermissionDto> getPermissionList(String keyword) {
		List<PermissionDto> permissionList = permissionMapper.getPermissionList(keyword);
		if(CollectionUtils.isEmpty(permissionList))
		{
			return null;
		}
		Map<Integer,Set<PermissionDto>> resultMap = new HashMap<>();
		Set<PermissionDto> lp ;
		Set<PermissionDto> parentList = new HashSet<>();
		Integer parentId;
		for(PermissionDto dto : permissionList)
		{
			parentId = dto.getParentId();
			if(null == parentId)
			{
				parentList.add(dto);
				continue;
			}
			if(resultMap.containsKey(parentId))
			{
				lp = resultMap.get(parentId);
				lp.add(dto);
			}
			else
			{
				lp = new HashSet<>();
				lp.add(dto);
				resultMap.put(parentId,lp);
			}
		}
		for(PermissionDto dto : parentList)
		{
			Integer id = dto.getId();
			dto.setKids(resultMap.remove(id));
		}
		if(!resultMap.isEmpty())
		{
			Set<Integer> keySet = resultMap.keySet();
			for(Integer key : keySet)
			{
				parentList.addAll(resultMap.get(key));
			}
		}
		return parentList;
	}

}
