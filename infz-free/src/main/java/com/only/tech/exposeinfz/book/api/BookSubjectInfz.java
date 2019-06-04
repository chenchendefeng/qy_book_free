package com.only.tech.exposeinfz.book.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.admin.BookCheckedInfoDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.dto.book.BookSubjectReqDto;
import com.only.tech.exposeinfz.activity.dto.RespDto;
import java.util.List;

/**
 * infz: 书籍专题
 * @author shutong
 * @since 2019/04/28
 */
public interface BookSubjectInfz {


	/**
	 * 分页查询
	 * @param pageReq
	 * @param status
	 * @param subjectType
	 * @return
	 */
	PageData<BookSubjectDto> pageListByCondition(PageReq pageReq, Integer status, String subjectType);

	/**
	 * 添加or修改
	 * @param reqDto
	 * @return
	 */
	RespDto saveOrUpdate(BookSubjectReqDto reqDto);


	/**
	 * 检查BID列表
	 * @param bidList
	 * @return
	 */
	BookCheckedInfoDto checkBookCbidList(List<Long> bidList);

	/**
	 * 删除书籍专题
	 * @param bookSubjectId
	 */
	void deleteBookSubject(Long bookSubjectId);

	/**
	 * 查询书籍专题信息
	 * @param id
	 * @return
	 */
	BookSubjectDto getDetailById(Long id);

	/**
	 * 查询书籍 by bid
	 * @param bid
	 * @return
	 */
	BookInfoDetailDto queryBookByBid(Long bid);
}
