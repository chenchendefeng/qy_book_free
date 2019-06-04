package com.only.tech.admin.controller;

import com.only.tech.admin.service.facade.GoodsFacade;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ctr: 商品（ 会员 | ... ）
 * @author shutong
 *
 */
@Slf4j
@RestController
@RequestMapping("/goods")
@Api(tags="商品管理")
public class GoodsMgrController extends BaseController {
	

	@Autowired
	private GoodsFacade goodsFacade;


	/**
	 * 分页查询商品列表（ 会员| ...）
	 * @param goodsType
	 * @return
	 */
	@ApiOperation(value = "分页查询商品信息（会员 | ...）")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "goodsType", dataType = "String", value = "商品类型 (vip 会员 | ...)" ),
		@ApiImplicitParam(name = "saleStatus", dataType = "int", value = "上架状态 (1：上架 | 0：下架 )")
	})
	@RequestMapping(value = "/pageListGoods", method = RequestMethod.POST)
	public ResultDto<Goods> pageListGoods(PageReq pageReq, String goodsType, Integer saleStatus){
		try {

			PageData<Goods> pageData=this.goodsFacade.pageListByCondition(pageReq, goodsType,saleStatus);
			return ResultDto.succesResult(pageData);

		} catch (Exception e) {
			log.error("商品查询异常" ,e);
			return ResultDto.errorResult("商品查询异常");
		}
	}

	/**
	 * 新增或者修改
	 * @return
	 */
	@ApiOperation(value = "新增或者修改商品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", dataType = "int", value = "主键（新增记录，不需要）",required = false),
			@ApiImplicitParam(name = "goodsType", dataType = "String", value = "商品类型 (vip 会员 | ...)",required = true),
			@ApiImplicitParam(name = "goodsPrice", dataType = "int", value = "商品价格（会员：分 |...）",required = true),
			@ApiImplicitParam(name = "goodsNum", dataType = "int", value = "数量（ 会员：天 | ..）",required = true ),
			@ApiImplicitParam(name = "goodsName", dataType = "String", value = "商品名",required = true),
			@ApiImplicitParam(name = "goodsMsg", dataType = "String", value = "商品描述 (副标题)",required = false),
			@ApiImplicitParam(name = "noticeMsg", dataType = "String", value = "提示描述 (角标)",required = false),
			@ApiImplicitParam(name = "goodsCode", dataType = "String", value = "商品编号(新增记录，不需要)",required = false),
			@ApiImplicitParam(name = "saleStatus", dataType = "int", value = "上架状态 (1：上架 | 0：下架 )",required = true)
	})
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public ResultDto saveOrUpdate(GoodsDto goodsDto) {
		Long id=goodsDto.getId();
		try {

			//添加or修改
			this.goodsFacade.saveOrUpdate(goodsDto);

			if(id==null){
				return ResultDto.responseResult("success","新增成功");
			}else{
				return ResultDto.responseResult("success","修改成功");
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
	 * 查询商品信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询商品信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", dataType = "int", value = "主键",required = true)
	})
	@RequestMapping(value = "/getGoodsInfo", method = RequestMethod.POST)
	public ResultDto<Goods> getGoodsInfo(Long id){
		try {

			Goods goods=this.goodsFacade.getOneById(id);
			return ResultDto.succesResult(goods);

		} catch (Exception e) {
			log.error("查询商品信息异常" ,e);
			return ResultDto.errorResult("查询商品信息异常");
		}
	}






}
