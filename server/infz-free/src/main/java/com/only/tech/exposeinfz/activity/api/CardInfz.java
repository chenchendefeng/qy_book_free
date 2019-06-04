package com.only.tech.exposeinfz.activity.api;

import com.only.tech.exposeinfz.activity.dto.CardDto;

import java.util.List;

/**
 * 接口：卡片
 * @author shutong
 * @since 2019/03/08
 */
public interface CardInfz {


    /**
     * 查询卡片列表
     * @param status
     * @return
     */
    List<CardDto> listByStatus(Integer status);

    /**
     * 添加or修改
     * @param cardDto
     */
    void saveOrUpdate(CardDto cardDto);

    /**
     * 修改状态
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);
}
