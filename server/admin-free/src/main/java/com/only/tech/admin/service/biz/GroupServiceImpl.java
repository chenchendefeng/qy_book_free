package com.only.tech.admin.service.biz;

import com.only.tech.entity.admin.GroupEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.GroupEntityMapper;
import com.only.tech.admin.service.biz.GroupService;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupEntityMapper, GroupEntity> implements GroupService{

}
