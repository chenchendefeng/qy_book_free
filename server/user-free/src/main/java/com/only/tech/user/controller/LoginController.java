package com.only.tech.user.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.Constants;
import com.only.tech.constant.UserRedisKeyConstants;
import com.only.tech.user.service.facade.LoginFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import ooh.chaos.util.AccountValidatorUtil;
import ooh.chaos.util.BeanValidation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器：用户登录登出
 * @author shutong
 * @date 2019/04/30
 */
@Api(tags="登录登出")
@Slf4j
@RequestMapping("/main")
@RestController
public class LoginController extends BaseController {

	@Autowired
	private LoginFacade loginFacade;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	/**
	 * 登录APP-微信授权
	 */
	@ApiOperation(value = "微信登录", notes = "微信登录接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "code", value = "用户换取access_token的code", dataType = "String",required = true),
			@ApiImplicitParam(name = "imei", value = "设备号", dataType = "String",required = true),
			@ApiImplicitParam(name = "source", value = "客户端类型 IOS, Android, H5，PC", dataType = "String",required = true) ,
			@ApiImplicitParam(name = "channel", value = "渠道号", dataType = "String",required = true)
	})
	@RequestMapping(value = "/wechatLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto wechatLogin(String code, String imei, String source,String channel, HttpServletRequest request) {

		try {
			if (StringUtils.isBlank(code)) {
				return ResultDto.errorResult("用户换取access_token的code不能为空");
			}
			if (StringUtils.isBlank(source)) {
				return ResultDto.errorResult("用户来源不能为空");
			}
			if (StringUtils.isBlank(imei)) {
				return ResultDto.errorResult("设备号不能为空");
			}
			if (StringUtils.isBlank(channel)) {
				return ResultDto.errorResult("渠道号不能为空");
			}

			return loginFacade.loginByWechat(code,imei,source,channel,request);

		} catch (Exception e) {
			log.error("登录失败", e);
			return ResultDto.errorResult("登录失败");
		}

	}

	/**
	 * 登录APP-手机验证码
	 */
	@ApiOperation(value = "手机登录", notes = "手机登录接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phone", value = "手机号码", dataType = "String",required = true),
			@ApiImplicitParam(name = "zone", value = "国家代码（86）", dataType = "String",required = true),
			@ApiImplicitParam(name = "code", value = "验证码", dataType = "String",required = true),
			@ApiImplicitParam(name = "imei", value = "设备号", dataType = "String"),
			@ApiImplicitParam(name = "source", value = "客户端类型 IOS, Android, H5", dataType = "String",required = true) ,
			@ApiImplicitParam(name = "channel", value = "渠道号", dataType = "String")
	})
	@RequestMapping(value = "/phoneLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto phoneLogin(String phone, String zone, String code, String imei, String source,String channel,
			HttpServletRequest request) {

		try {
			if (StringUtils.isBlank(phone)) {
				return ResultDto.errorResult("手机号码不能为空");
			}
			if (StringUtils.isBlank(zone)) {
				return ResultDto.errorResult( "区号不能为空");
			}
			if (StringUtils.isBlank(code)) {
				return ResultDto.errorResult("验证码不能为空");
			}
			if (StringUtils.isBlank(source)) {
				return ResultDto.errorResult( "用户来源不能为空");
			}
			if (!AccountValidatorUtil.isMobile(phone)){
				return ResultDto.errorResult("手机号错误");
			}
			return loginFacade.loginByPhone(phone,zone,code,imei,source,channel,request);

		} catch (Exception e) {
			log.error("登录失败", e);
			return ResultDto.errorResult("登录失败");
		}

	}

	/**
	 * 登录APP-游客
	 */
	@ApiOperation(value = "游客登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "imei", value = "设备号", dataType = "String", required = false ),
			@ApiImplicitParam(name = "source", value = "客户端类型 IOS, Android, H5", dataType = "String",required = true) ,
			@ApiImplicitParam(name = "channel", value = "渠道号", dataType = "String", required = true)
	})
	@RequestMapping(value = "/visitorLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto visitorLogin(String imei, String source,String channel,HttpServletRequest request ) {

		try {
			if (StringUtils.isBlank(source) || StringUtils.isBlank(channel) ) {
				return ResultDto.errorResult( "参数错误");
			}

			if(imei==null){
				return ResultDto.succesResult();
			}

			return loginFacade.visitorLogin(imei,source,channel,request);

		} catch (Exception e) {
			log.error("游客登录失败", e);
			return ResultDto.errorResult("游客登录失败");
		}

	}

	/**
	 * 用户登出
	 */
	@Access
	@ApiOperation(value = "登出接口")
	@ApiImplicitParams({ @ApiImplicitParam(name = "cuId", value = "用户id", dataType = "Long"),
			@ApiImplicitParam(name = "userToken", value = "token", dataType = "String") })
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResultDto logout(Long cuId, String userToken, HttpServletRequest request) {
		try {

			// 清除redis中的用户id
			String uidKey = UserRedisKeyConstants.USER_TOKEN + userToken;
			redisTemplate.delete(uidKey);

			// 清楚redis中的token
			String md5Key = DigestUtils.md5Hex(Constants.TOKEN_KEY_PRE + cuId);
			String tokenKey = UserRedisKeyConstants.USER_TOKEN + md5Key;
			redisTemplate.delete(tokenKey);
			// 销毁session
			request.getSession().invalidate();

			return ResultDto.succesResult("登出成功");
		} catch (Exception e) {
			log.error("登出失败",e);
			return ResultDto.errorResult("登出失败");
		}
	}

}