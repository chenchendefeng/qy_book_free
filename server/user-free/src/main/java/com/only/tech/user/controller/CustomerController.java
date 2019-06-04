package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultString;
import com.only.tech.constant.Constants;
import com.only.tech.dto.user.CustomerBizInfoDto;
import com.only.tech.dto.user.UpdateCustomerInfoDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.user.service.biz.CustomerService;
import com.only.tech.user.service.facade.CustomerFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.service.OSSPicService;
import ooh.chaos.targetMethod.Access;
import ooh.chaos.util.BeanValidation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 控制层：用户
 * @author shutong
 * @since  2019/04/30
 */
@Api(tags="用户")
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private OSSPicService oSSPicService;

    /**
     * 头像后缀
     */
    public final static List<String> STRUFF_LIST = new ArrayList<String>();

    static {
        STRUFF_LIST.add(".jpg");
        STRUFF_LIST.add(".png");
        STRUFF_LIST.add(".gif");
    }

    /**
     * 获取用户业务信息
     */
    @Access
    @ApiOperation(value = "获取用户业务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户ID", dataType = "String", required = true )
    })
    @RequestMapping(value = "/getCustomerBizInfo", method = RequestMethod.POST)
    public ResultDto<CustomerBizInfoDto> getCustomerBizInfo(Long cuId) {
        try {
            CustomerBizInfoDto customerBizInfoDto = this.customerFacade.getCustomerBizInfo(cuId);
            return ResultDto.succesResult(customerBizInfoDto);
        } catch (Exception e) {
            log.error("获取用户业务信息失败",e);
            return ResultDto.errorResult("获取用户业务信息失败");
        }
    }

    @Access
    @ApiOperation(value = "修改用户呢称、性别、头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long",required = true),
            @ApiImplicitParam(name = "nickName", value = "用户昵称", dataType = "String"),
            @ApiImplicitParam(name = "avatar", value = "用户头像路径", dataType = "String"),
            @ApiImplicitParam(name = "sex", value = "性别（ boy | girl ）", dataType = "String"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<Customer> update(UpdateCustomerInfoDto customer, @RequestParam(required = false) MultipartFile file) {

        ResultDto resultDto = null;

        try {

            Customer user = this.customerService.getByCuId(customer.getCuId());
            if (user == null) {
                resultDto = ResultDto.errorResult("用户不存在，无法修改");
                return resultDto;
            }

            MultipartFile pic = file;
            // 校验图片(非必要校验字段)
            if (null != pic && !pic.isEmpty()) {
                // 校验上传图片格式
                String originalFilename = pic.getOriginalFilename();// 获取上传文件的文件名
                String struff = originalFilename.substring(originalFilename.lastIndexOf("."));
                if (!STRUFF_LIST.contains(struff)) {
                    resultDto = ResultDto.responseResult(ResultString.ERROR, "图像类型不正确（支持JPG,PNG,GIF格式）");
                    return resultDto;
                }
                // 校验上传图片大小
                long fileSize = pic.getSize();
                if (fileSize >= 1024 * 500 * 1) {
                    resultDto = ResultDto.responseResult(ResultString.ERROR, "用户头像大小不能超过500KB");
                    return resultDto;
                }
                // 调用OSS上传头像方法
                try {
                    String fileName = UUID.randomUUID() + "-" + new Date().getTime()
                            + originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
                    File newFile = new File(fileName);
                    FileUtils.copyInputStreamToFile(pic.getInputStream(), newFile);
                    // 上传新头像
                    oSSPicService.uploadHeadFile(newFile);
                    customer.setAvatar(Constants.USER_IMAGE_STORAGE_PATH + fileName);
                    // 删除之前的头像
                    if (!Constants.USER_DEFAULT_HEADER_PATH.equals(user.getAvatar())) {
                        oSSPicService.deleteHeadFile(user.getAvatar().substring(user.getAvatar().lastIndexOf("/") + 1));
                    }
                    // 删除项目的临时文件
                    FileUtils.deleteQuietly(newFile);
                } catch (Exception e) {
                    log.error("用户头像上传失败", e);
                    resultDto = ResultDto.responseResult(ResultString.ERROR, "用户头像上传失败");
                    return resultDto;
                }
            }
            Customer customerUpdated = this.customerService.update(customer);
            resultDto = ResultDto.succesResult(customerUpdated);
            return resultDto;
        } catch (Exception e) {
            log.error("修改用户失败", e);
            resultDto = ResultDto.responseResult(ResultString.ERROR, "修改用户失败");
            return resultDto;
        }

    }



}