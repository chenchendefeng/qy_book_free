package com.only.tech.payment.controller;

import com.only.tech.base.result.ResultDto;
import com.only.tech.payment.common.constant.WXPayConstants;
import com.only.tech.payment.service.facade.WeiXinPayFacade;
import com.only.tech.payment.service.handler.WXNativePayHandler;
import com.only.tech.payment.service.handler.WeiXinPayResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.controller.BaseController;
import ooh.chaos.targetMethod.Access;
import ooh.chaos.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 微信支付
 * @author shutong
 * @since 2019/05/15
 */
@Slf4j
@RestController
@RequestMapping("/wxpay/")
@Api(tags="微信支付")
public class WXPayController extends BaseController {
	
	@Autowired
	private WeiXinPayFacade weiXinPayFacade;

	@Autowired
	private WeiXinPayResultHandler weiXinPayResultHandler;

	@Autowired
	private WXNativePayHandler wxNativePayHandler;

	/**
	 * 微信app支付统一下单_APP支付
	 * @param request
	 * @param cuId
	 * @return
	 */
	@ApiOperation(value = "微信支付下单接口")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "goodsId", dataType = "long", value = "商品id", required = true),
		@ApiImplicitParam(paramType = "query", name = "deviceInfo", dataType = "String", value = "设备号", required = false),
		@ApiImplicitParam(paramType = "query", name = "systemType", dataType = "String", value = "系统类型", required = false),
		@ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "uid", required = true)
	})
	@RequestMapping(value = "/APP/weixinAppPay", method = RequestMethod.POST)
	@Access
	public ResultDto weixinAppPay(HttpServletRequest request, Long cuId, String deviceInfo, Long goodsId, String systemType){
		String ipAddr = request.getRemoteAddr();
		try {

			if( goodsId == null || cuId == null){
				ResultDto.errorResult("参数异常");
			}

			Map<String, String> resultMap = weiXinPayResultHandler.weixinUnifiedOrder(ipAddr,cuId,goodsId,deviceInfo,systemType,WXPayConstants.TRADE_TYPE_APP);
			return ResultDto.succesResult(resultMap);

		} catch (Exception e) {
			log.error("微信下单异常:",e);
			return ResultDto.errorResult("微信下单异常");
		}
	}

	/**
	 * 微信app支付统一下单_二维码扫描支付
	 * @param request
	 * @param cuId
	 * @return
	 */
	@ApiOperation(value = "微信扫描支付下单接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "goodsId", dataType = "long", value = "商品id", required = true),
		@ApiImplicitParam(name = "uid", dataType = "long", value = "uid", required = true)
	})
	@RequestMapping(value = "/APP/weixinNativePay", method = RequestMethod.POST)
	@Access
	public ResultDto weixinNativePay(HttpServletRequest request, Long cuId, Long goodsId){
		String ipAddr = request.getRemoteAddr();
		try {

			if(goodsId == null || cuId == null){
				ResultDto.errorResult("参数异常");
			}

			Map<String, String> resultMap = weiXinPayResultHandler.weixinUnifiedOrder(ipAddr,cuId,goodsId,null,"PC",WXPayConstants.TRADE_TYPE_NATIVE);
			return ResultDto.succesResult(resultMap);
		} catch (Exception e) {
			log.error("微信下单异常:" ,e);
			return ResultDto.errorResult("微信下单异常");
		}
	}

	/**
	 * 微信支付结果-异步通知
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/result/notify", method = RequestMethod.POST)
	public void resultNotify(HttpServletRequest request,HttpServletResponse response){
		try {

			String resultXml = StringUtils.servletToString(request);
			log.info("weixinPayResultNotify resultXml={}",resultXml);
			response.getWriter().write(weiXinPayFacade.parseTradeNotify(resultXml));

		} catch (Exception e) {
			log.error("weixin pay error",e);
		}
	}

	/**
	 * 查询交易结果-微信端远程
	 * @param cuId
	 * @return
	 */
	@ApiOperation(value = "查询交易结果-微信端远程")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "cuId", dataType = "long", value = "用户ID", required = true)
	})
	@RequestMapping(value = "/result/query", method = RequestMethod.POST)
	@Access
	public ResultDto rradeResultQuery(Long cuId){
		try{

			weiXinPayFacade.executeQuery(cuId);
			return ResultDto.succesResult();

		} catch (Exception e) {
			log.error("异步查询交易结果失败: ", e);
			return ResultDto.errorResult("异步查询交易结果失败");
		}
	}

	/**
	 * 查询交易结果-本地数据库
	 * @param prepayId
	 * @return
	 */
	@ApiOperation(value = "查询交易结果(根据预订单ID)-本地数据库 , 返回结果：（ 0下单中 | 1-未查询 |  2-未支付 |  3-交易关闭 | 4-支付中 | 5-支付失败 | 6-支付成功  | -1 下单失败）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "prepayId", dataType = "string", value = "预订单ID", required = true)
	})
	@RequestMapping(value = "/result/queryTradeStatusByPrepayId", method = RequestMethod.POST)
	@Access
	public ResultDto queryTradeStatusByPrepayId(String prepayId){
		try{

			Integer tradeStatus=this.weiXinPayFacade.queryTradeStatusByPrepayId(prepayId);
			return ResultDto.succesResult(tradeStatus);

		} catch (Exception e) {
			log.error("查询交易结果失败: ", e);
			return ResultDto.errorResult("查询交易结果失败");
		}
	}

}
