package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.activity.AppPosition;
import java.util.List;

/**
 * 接口：app页面位置
 * @author shutong
 * @since 2019/03/10
 */
public interface AppPositionService extends IService<AppPosition> {

    /**
     * 根据位置编码找到位置
     * @param positionCode
     * @return
     */
    AppPosition getOneByCode(String positionCode);

    /**
     * 查询所有
     * @return
     */
    List<AppPosition> listAll();
}
