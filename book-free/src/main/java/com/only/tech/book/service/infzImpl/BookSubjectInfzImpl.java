package com.only.tech.book.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.book.service.biz.BookInfoService;
import com.only.tech.book.service.biz.BookSubjectItemService;
import com.only.tech.book.service.biz.BookSubjectService;
import com.only.tech.book.service.facade.BookSubjectFacde;
import com.only.tech.constant.BookConstants;
import com.only.tech.dto.admin.BookCheckedInfoDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.dto.book.BookSubjectReqDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.entity.book.BookSubject;
import com.only.tech.entity.book.BookSubjectItem;
import com.only.tech.exposeinfz.activity.dto.RespDto;
import com.only.tech.exposeinfz.book.api.BookSubjectInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 接口实现类：书籍专题
 * @author shutong
 * @since 2019/04/28
 */
@Slf4j
@Service(interfaceClass = BookSubjectInfz.class)
@Component
public class BookSubjectInfzImpl implements BookSubjectInfz {


	@Autowired
	private BookSubjectService bookSubjectService;

	@Autowired
	private BookSubjectItemService bookSubjectItemService;

	@Autowired
	private BookInfoService bookInfoService;

	@Autowired
	private BookSubjectFacde bookSubjectFacde;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 书籍专题列表
	 * @param pageReq
	 * @param status
	 * @return
	 */
	@Override
	public PageData<BookSubjectDto> pageListByCondition(PageReq pageReq, Integer status,  String subjectType) {

		Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
		List<BookSubject> bookSubjectList = this.bookSubjectService.listByCondition(subjectType,status);

		if(bookSubjectList ==null){
			return null;
		}

		PageData pageData = new PageData(page);
		List<BookSubjectDto> bookSubjectDtoList = new ArrayList<BookSubjectDto>();

		for(BookSubject bookSubject : bookSubjectList){
			BookSubjectDto bookSubjectDto=new BookSubjectDto();
			BeanUtils.copyProperties(bookSubject,bookSubjectDto);

			//装载书籍
			ArrayList<BookInfo> bookInfoList=new ArrayList<BookInfo>();
			List<BookInfoDetailDto> bookInfoDetailDtoList =this.bookSubjectItemService.listBySubjectId(null,bookSubject.getId());
			bookSubjectDto.setBookList(bookInfoDetailDtoList);
			bookSubjectDtoList.add(bookSubjectDto);
		}

		pageData.setData(bookSubjectDtoList);
		return pageData;
	}

	/**
	 * 批量绑定书籍
	 * @param subjectId
	 * @param cbidList
	 * @return
	 */
	private List<Long> uploadBookSubjectBook(Long subjectId, List<Long> cbidList) {

		List<Long> errorList=new ArrayList<>();//不存在的BID列表

		if(cbidList==null || cbidList.size()==0){
			return errorList;
		}

		BookSubject bookSubject=this.bookSubjectService.getById(subjectId);
		List<BookSubjectItem> itemList =new ArrayList<BookSubjectItem>();

		for (Long bid : cbidList){
			BookInfo bookInfo=this.bookInfoService.getOneByBid(bid);
			if(bookInfo!=null){
				BookSubjectItem item=new BookSubjectItem();
				item.setBid(bid);
				item.setSubjectId(subjectId);
				itemList.add(item);
			}else{
				errorList.add(bid); //cBID 无对应的书籍信息
			}
		}

		if(itemList.size()>0){
			this.bookSubjectItemService.saveBatch(itemList);
		}
		return errorList;
	}

	/**
	 * 新增or修改
	 * @param reqDto
	 * @return
	 */
	@Override
	public RespDto saveOrUpdate(BookSubjectReqDto reqDto) {

		Long id=reqDto.getId();
		RespDto respDto=new RespDto();

		//新增或者修改书籍专题
		BookSubject bookSubject =new BookSubject();
		BeanUtils.copyProperties(reqDto, bookSubject);

		if(id==null){
			bookSubject.setCreateTime(new Date());
		}

		this.bookSubjectService.saveOrUpdate(bookSubject);

		//新增或者修改书籍
		Long subjectId= bookSubject.getId();

		//先全部删除，再添加
		this.bookSubjectItemService.deleteBySubjectId(subjectId);
		List<Long> bidList=reqDto.getBidList();

		//去重
		Set set = new HashSet();
		List newList = new ArrayList();
		if(bidList!=null && bidList.size()>0){
            for (Iterator iter = bidList.iterator(); iter.hasNext();) {
                Object element = iter.next();
                if (set.add(element))
                    newList.add(element);
            }
			bidList.clear();
			bidList.addAll(newList);
        }

		List<Long> errorList=this.uploadBookSubjectBook(subjectId,bidList);
		respDto.setErrorList(errorList);
		respDto.setSuccess(true);

		//返回错误书籍编号列表
		return respDto;
	}


	@Override
	public BookCheckedInfoDto checkBookCbidList(List<Long> bidList) {

		BookCheckedInfoDto bookCheckedInfoDto=new BookCheckedInfoDto();
		List<Long> errorCbidList=new ArrayList<Long>();
		List<BookInfo> bookList=new ArrayList<BookInfo>();

		if(bidList==null || bidList.size()==0){
			return  bookCheckedInfoDto;
		}

		for(int i=0; i< bidList.size();i++){
			Long bid=bidList.get(i);
			BookInfo bookInfo=this.bookInfoService.getOneByBid(bid);
			if(bookInfo==null){
				errorCbidList.add(bid);
			}else{
				bookList.add(bookInfo);
			}
		}

		bookCheckedInfoDto.setBookList(bookList);
		bookCheckedInfoDto.setErrorBidList(errorCbidList);

		return bookCheckedInfoDto;
	}

	/**
	 * 删除书籍专题
	 * @param id
	 */
	@Override
	public void deleteBookSubject(Long id) {
		this.bookSubjectService.removeById(id);
	}

	/**
	 * 查询书籍专题信息
	 * @param id
	 * @return
	 */
	@Override
	public BookSubjectDto getDetailById(Long id) {

		BookSubject bookSubject=this.bookSubjectService.getById(id);
		if(bookSubject==null){
			return null;
		}

		BookSubjectDto bookSubjectDto=new BookSubjectDto();
		BeanUtils.copyProperties(bookSubject,bookSubjectDto);

		//装载书籍
		List<BookInfoDetailDto> bookSubjectBookList =this.bookSubjectItemService.listBySubjectId(null, bookSubject.getId());
		bookSubjectDto.setBookList(bookSubjectBookList);

		//统计男生女生书籍数量
		Integer boyBooks=0;
		Integer girlBooks=0;
		for(BookInfoDetailDto dto: bookSubjectBookList){
			String sexMark=dto.getSexMark();
			if(BookConstants.SEXFLAG_GIRL.equals(sexMark)){
				girlBooks++;
			}else if(BookConstants.SEXFLAG_BOY.equals(sexMark)){
				boyBooks++;
			}
		}
		bookSubjectDto.setBoyBooks(boyBooks);
		bookSubjectDto.setGirlBooks(girlBooks);

		return bookSubjectDto;
	}

	/**
	 * 查询书籍 by bid
	 * @param bid
	 * @return
	 */
	@Override
	public BookInfoDetailDto queryBookByBid(Long bid) {
		return this.bookInfoService.getBookInfoDetail(bid);
	}


}
