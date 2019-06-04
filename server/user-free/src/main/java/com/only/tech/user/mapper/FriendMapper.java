package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.user.CustomerBaseDto;
import com.only.tech.dto.user.FriendInfoDto;
import com.only.tech.entity.user.Friend;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户好友表 Mapper 接口
 * </p>
 *
 * @author ZHI
 * @since 2019-03-13
 */
@Repository
public interface FriendMapper extends BaseMapper<Friend> {

    List<CustomerBaseDto> getFriendList(Long cuId);

    List<FriendInfoDto> friendInfoList(Long cuId);
}
