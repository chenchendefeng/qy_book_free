package com.only.tech.user.controller;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.user.common.model.PaginationDto;
import com.only.tech.user.dto.FaqRespDto;
import com.only.tech.user.service.biz.FaqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/faq")
@RestController
@Api(tags="帮助中心")
public class FaqController extends BaseController {

    @Autowired
    private FaqService faqService;

    @Access
    @ApiOperation(value = "FAQ查詢", notes = "分页查询FAQ")
    @ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "页数", dataType = "int", required = false),
            @ApiImplicitParam(name = "pageSize", value = "用户反馈", dataType = "int", required = false) })
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDto getFaqList(String channle, PageReq pageReq) {

        PageData<FaqRespDto> paginationDto = faqService.getFaqList(channle,pageReq);
        return ResultDto.succesResult(paginationDto);
    }
}
