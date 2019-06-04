package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.StartPage;

import java.util.List;

/**
 * 服务声明类-开屏页
 * @author shutong
 * @since 2019-01-16
 */
public interface StartPageService extends IService<StartPage> {

    /**
     * 删除开屏页（包含OSS文件）
     * @param startPageID
     */
    void deleteById(Long startPageID);

    /**
     * 获取当然开屏页
     * @param channelCode
     * @param clientType
     * @return
     */
    StartPage getCurStartPage(String channelCode, String clientType);

    /**
     * 根据状态和渠道号查询列表
     * @param status
     * @param channelCode
     * @return
     */
    List<StartPage> listByStatusAndChannelCode(String status, String channelCode);
}
