package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultString;
import com.only.tech.user.common.model.PaginationDto;
import com.only.tech.user.dto.FeedbackReqDto;
import com.only.tech.user.service.biz.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import ooh.chaos.util.BeanValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 意见反馈controller
 */
@Slf4j
@RequestMapping("/api/feedback")
@RestController
@Api(tags="用户反馈")
public class FeedbackController extends BaseController {

	@Autowired
	private FeedbackService feedbackService;

	@Access
	@ApiOperation(value = "用户反馈保存API", notes = "保存反馈接口")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto saveFeedback(FeedbackReqDto dto, HttpServletRequest request) {
		ResultDto resultDto = null;
		try {

			BeanValidation<FeedbackReqDto> validationResult = new BeanValidation<FeedbackReqDto>(dto);
			if (validationResult.hasError()) {
				resultDto = ResultDto.responseResult(ResultString.ERROR, validationResult.getError(),
						validationResult.getAllErrors());
				return resultDto;
			}

			feedbackService.saveFeedback(dto);

			resultDto = ResultDto.responseResult(ResultString.SUCCESS, "反馈成功");
			return resultDto;
		} catch (Exception e) {
			log.error("反馈失败", e);
			resultDto = ResultDto.responseResult(ResultString.ERROR, "反馈失败");
			return resultDto;
		}

	}

	@Access
	@ApiOperation(value = "用户反馈查询", notes = "分页查询用户反馈")
	@ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "页数", dataType = "int", required = false),
			@ApiImplicitParam(name = "pageSize", value = "用户反馈", dataType = "int", required = false) })
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResultDto<PaginationDto> selectFeedbackByPage(HttpServletRequest request, Long cuId,Integer page,  Integer pageSize) {

		if (cuId == null) {
			return ResultDto.responseResult(ResultString.ERROR, "用户id不能为空");
		}
		log.info("cuId: {}", cuId);
		PaginationDto paginationDto = feedbackService.selectFeedbackByPage(cuId, page, pageSize);
		return ResultDto.succesResult(paginationDto);
	}

}
