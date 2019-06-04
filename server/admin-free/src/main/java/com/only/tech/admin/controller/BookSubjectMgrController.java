package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.BookSubjectFacade;
import com.only.tech.admin.common.util.ExcelUtils;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.BookCheckedInfoDto;
import com.only.tech.dto.book.BookInfoDetailDto;
import com.only.tech.dto.book.BookSubjectDto;
import com.only.tech.dto.book.BookSubjectReqDto;
import com.only.tech.entity.book.BookInfo;
import com.only.tech.exposeinfz.activity.dto.RespDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;

@Api(tags="书籍专题")
@Slf4j
@RestController
@RequestMapping("/bookSubject")
public class BookSubjectMgrController {

	@Autowired
	private BookSubjectFacade bookSubjectFacade;

	/**
	 * 书籍专题列表
	 * @param pageReq
	 * @param status
	 * @param subjectType
	 * @return
	 */
	@ApiOperation(value = "书籍专题列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "subjectType", dataType = "string", value = "专题类型：（ boy:男生 | girl:女生 ）", required = true ),
			@ApiImplicitParam(name = "status", dataType = "int", value = "状态（ 1:上架| 0:未上架 ）" )
	})
	@RequestMapping(value = "/listByCondition", method = RequestMethod.POST)
	public ResultDto<BookSubjectDto> listByCondition(PageReq pageReq, Integer status, String subjectType) {
		try {
			return ResultDto.succesResult(this.bookSubjectFacade.pageListByCondition(pageReq,status,subjectType));
		} catch (Exception e) {
			log.error("查询专题列表异常", e);
			return ResultDto.errorResult("查询专题列表异常");
		}
	}


	/**
	 * 书籍专题详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "书籍专题详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", dataType = "int", value = "专题ID", required = true)
	})
	@RequestMapping(value = "/getBookSubjectDetail", method = RequestMethod.POST)
	public ResultDto<BookSubjectDto> getBookSubjectDetail(Long  id){
		try {
			return ResultDto.succesResult(this.bookSubjectFacade.getDetailById(id) );
		} catch (Exception e) {
			log.error("查询书籍专题详情异常", e);
			return ResultDto.errorResult("查询书籍专题详情异常");
		}
	}

	@ApiOperation(value = "删除书籍专题")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", dataType = "int", value = "书籍专题ID",required = true)
	})
	@RequestMapping(value = "/deleteBookSubject", method = RequestMethod.POST)
	public ResultDto deleteBookSubject(Long id) {
		try {

			if(id==null){
				return ResultDto.errorResult("参数异常");
			}

			this.bookSubjectFacade.deleteBookSubject(id);
			return ResultDto.succesResult();
		} catch (Exception e) {
			log.error("删除书籍专题异常", e);
			return ResultDto.errorResult("删除书籍专题异常");
		}
	}

	/**
	 * 新增或者修改书籍专题
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "新增或者修改书籍专题")
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public ResultDto saveOrUpdate(BookSubjectReqDto dto) {
		Long id=dto.getId();
		try {

			//添加or修改
			RespDto respDto= bookSubjectFacade.saveOrUpdate(dto);

			if(respDto.isSuccess()){
				if(id==null){
					return ResultDto.responseResult("success","新增成功",respDto.getErrorList());
				}else{
					return ResultDto.responseResult("success","修改成功",respDto.getErrorList());
				}
			}else{
				return ResultDto.errorResult(respDto.getErrorMsg());
			}

		} catch (Exception e) {
			if(id==null) {
				log.error("新增失败", e);
				return ResultDto.errorResult("新增失败");
			}else{
				log.error("修改失败", e);
				return ResultDto.errorResult("修改失败");
			}
		}
	}

	/**
	 * 书籍bid文件读取
	 * @param file
	 * @return
	 */
	@ApiOperation(value = "书籍bid文件读取")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "file", value = "上传excel文件", dataType = "MultipartFile",required = true)

	})
	@PostMapping(value = "/uploadCBIDExcel",headers="content-type=multipart/form-data",consumes = "multipart/*")
	public ResultDto<BookCheckedInfoDto> uploadCBIDExcel(MultipartFile file) {

		try {

			if(file==null){
				return  ResultDto.errorResult("上传的文件为空");
			}

			String originalFilename = file.getOriginalFilename();// 获取上传文件的文件名

			// 校验文件类型
			String fileType=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			if (!"cvs".equals(fileType) && !"xls".equals(fileType)) {
				return  ResultDto.errorResult( "请上传excel文件");
			}
			//读取excel数据
            List<String> cbidStrList= ExcelUtils.readCellContent(file);
			List<Long> cbidList=new ArrayList<Long>();
			for(String cbidStr: cbidStrList){
				cbidList.add(Long.valueOf(cbidStr));
			}

			//检查书籍CBID是否异常
			BookCheckedInfoDto bookCheckedInfoDto= bookSubjectFacade.checkBookCbidList(cbidList);
			return ResultDto.succesResult(bookCheckedInfoDto);

		} catch (Exception e) {
			log.error("书籍cbid文件读取失败", e);
			return  ResultDto.errorResult("书籍cbid文件读取失败");
		}

	}


	/**
	 * 查询书籍by bid
	 * @param bid
	 * @return
	 */
	@ApiOperation(value = "根据bid查询书籍")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bid", value = "书籍bid", dataType = "int",required = true)

	})
	@PostMapping(value = "/queryBookByBid" )
	public ResultDto<BookInfoDetailDto> queryBookByBid(Long bid) {

		try {

			if(bid==null){
				return  ResultDto.errorResult("参数异常");
			}

			BookInfoDetailDto bookInfoDetailDto=this.bookSubjectFacade.queryBookByBid(bid);
			return ResultDto.succesResult(bookInfoDetailDto);


		} catch (Exception e) {
			log.error("查询书籍失败", e);
			return  ResultDto.errorResult("查询书籍失败");
		}

	}




}
