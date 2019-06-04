package com.only.tech.admin.controller;


import com.only.tech.admin.service.biz.UserService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@Slf4j
@Api(tags="登录")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;
	@ApiOperation(value = "logout", notes = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultDto logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject != null) {
                subject.logout();
            }
            return ResultDto.succesResult();
        } catch (Exception e) {
            log.error("logout error", e);
            return ResultDto.errorResult();
        }
    }
	@ApiOperation(value = "login", notes = "登录")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "loginName", dataType = "String", value = "loginName", required = true),
	@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", value = "password", required = true) })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDto login(@RequestParam(value = "loginName", required = false) String loginName,
                           @RequestParam(value = "password", required = false) String password,
                           HttpSession session, HttpServletRequest request) {
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
            log.error("login error");
            return ResultDto.errorResult();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserAdminDto user = (UserAdminDto) subject.getPrincipal();
            session.setAttribute("user", user);
            session.setAttribute("currentUserId",user.getId().longValue());
            //失效时间60分钟
            SecurityUtils.getSubject().getSession().setTimeout(3600000l);
            UserEntity ue = new UserEntity();
            ue.setLastLoginIp(request.getRemoteAddr());
            ue.setLastLoginTime(new Date());
            ue.setDateUpdate(new Date());
            ue.setId(user.getId());
            userService.updateById(ue);
            return ResultDto.succesResult(user);
        } catch (Exception e) {
            log.error("login error", e);
            return ResultDto.errorResult();
        }
    }
}
