package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.ReadFootprint;

import java.util.List;

/**
 * <p>
 * 阅读足迹 服务类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/19
 */
public interface ReadFootprintService extends IService<ReadFootprint> {

    /**
     * 查询用户阅读足迹
     * @param cuId
     * @return
     */
    List<ReadFootprint> listByUid(Long cuId);
}
