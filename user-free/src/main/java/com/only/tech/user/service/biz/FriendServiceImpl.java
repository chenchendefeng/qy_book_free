package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.only.tech.dto.user.CustomerBaseDto;
import com.only.tech.dto.user.FriendInfoDto;
import com.only.tech.entity.user.Friend;
import com.only.tech.user.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户好友表 服务实现类
 * </p>
 *
 * @author ZHI
 * @since 2019-03-13
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<CustomerBaseDto> getFriendList(Long cuId) {
        return friendMapper.getFriendList(cuId);
    }

    @Override
    public List<FriendInfoDto> friendInfoList(Long cuId) {
        return friendMapper.friendInfoList(cuId);
    }
}
