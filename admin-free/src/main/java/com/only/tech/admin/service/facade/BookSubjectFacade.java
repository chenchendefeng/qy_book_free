package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.admin.BookCheckedInfoDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.dto.book.BookSubjectReqDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.exposeinfz.activity.dto.RespDto;
import com.only.tech.exposeinfz.book.api.BookSubjectInfz;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookSubjectFacade {

	@Reference
	private BookSubjectInfz bookSubjectInfz;

	/**
	 * 列表
	 * @param pageReq
	 * @param status
	 * @param subjectType
	 * @return
	 */
	public PageData<BookSubjectDto> pageListByCondition(PageReq pageReq, Integer status, String subjectType) {
		return this.bookSubjectInfz.pageListByCondition(pageReq,status,subjectType);
	}


	/**
	 * 添加或者修改
	 * @param reqDto
	 * @return
	 */
    public RespDto saveOrUpdate(BookSubjectReqDto reqDto) {
		return this.bookSubjectInfz.saveOrUpdate(reqDto);
    }


	/**
	 * 检查CBID列表
	 * @param cbidList
	 * @return
	 */
	public BookCheckedInfoDto checkBookCbidList(List<Long> cbidList) {
		return this.bookSubjectInfz.checkBookCbidList(cbidList);
	}

	/**
	 * 删除书籍专题
	 * @param bookSubjectId
	 */
    public void deleteBookSubject(Long bookSubjectId) {
    	this.bookSubjectInfz.deleteBookSubject(bookSubjectId);
    }


	public BookSubjectDto getDetailById(Long id) {
        return this.bookSubjectInfz.getDetailById(id);
	}

	/**
	 * 查询书籍 by bid
	 * @param bid
	 * @return
	 */
    public BookInfoDetailDto queryBookByBid(Long bid) {
    	return this.bookSubjectInfz.queryBookByBid(bid);
    }
}
