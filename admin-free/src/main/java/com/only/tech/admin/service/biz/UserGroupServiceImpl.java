package com.only.tech.admin.service.biz;

import com.only.tech.entity.admin.UserGroupRelativeEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.admin.mapper.UserGroupRelativeEntityMapper;
import com.only.tech.admin.service.biz.UserGroupRelativeService;

@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupRelativeEntityMapper, UserGroupRelativeEntity> implements UserGroupRelativeService{

}
