package com.only.tech.exposeinfz.activity.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.dto.BookCommendDto;

import java.util.List;

/**
 * 接口：书籍评论
 * @author shutong
 * @since 2019/03/08
 */
public interface BookCommendInfz {


    /**
     * 分页条件查询书籍评论
     * @param pageReq
     * @param uid
     * @param cbid
     * @param status
     * @param starNum
     * @param isSort 
     * @return
     */
    PageData<BookCommendDto> pageListByCondition(PageReq pageReq, Long uid, Long cbid, String status, Integer starNum, boolean isSort);

    /**
     * 修改书籍评论
     * @param commendId
     * @param content
     * @param starNum
     */
    void updateBookCommend(Long commendId, String content, Integer starNum);

    /**
     * 审核评论
     * @param commendId
     * @param status
     */
    void auditBookCommend(Long commendId, String status);

    /**
     * 书籍评论详情
     * @param commendId
     */
    BookCommendDto detailBookCommend(Long commendId);

    /**
     * 书籍平均平均值
     * @param cbid
     * @return
     */
    float avgStarNum(Long cbid);

    /**
     * 查询书籍所有评论
     * @param cbid
     * @param status
     * @return
     */
    List<BookCommendDto> listByCondition(Long cbid,String status);

    /**
     * 查询用户对一本书对评论
     * @param uid
     * @param cbid
     * @return
     */
    BookCommendDto getOneByCondition(Long uid, Long cbid);
}
