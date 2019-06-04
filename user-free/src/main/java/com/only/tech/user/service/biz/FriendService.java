package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.user.CustomerBaseDto;
import com.only.tech.dto.user.FriendInfoDto;
import com.only.tech.entity.user.Friend;

import java.util.List;

/**
 * <p>
 * 用户好友表 服务类
 * </p>
 *
 * @author ZHI
 * @since 2019-03-13
 */
public interface FriendService extends IService<Friend> {

    List<CustomerBaseDto> getFriendList(Long cuId);

    List<FriendInfoDto> friendInfoList(Long cuId);
}
