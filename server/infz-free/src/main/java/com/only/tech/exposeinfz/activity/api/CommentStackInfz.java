package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.dto.CommentStackDto;

import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/7
 */
public interface CommentStackInfz {
    PageData getPage(Integer status, String keyword, PageReq pageReq);

    CommentStackDto getById(Integer id);

    boolean insert(CommentStackDto dto);

    boolean update(CommentStackDto dto);

    boolean updateStatus(List<Integer> idList, Integer status);

    boolean delete(Integer id);
}
