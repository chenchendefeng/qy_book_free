package com.only.tech.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应公共实体类
 * @param <T>
 */
@Data
@ApiModel(value = "返回数据")
public class ResultDto<T> implements Serializable {

	/**
	 * 响应编码
	 */
	@ApiModelProperty("响应码  success/error")
	private String result;

	/**
	 * 响应消息
	 */
	@ApiModelProperty(value = "响应信息")
	private String msg;

	/**
	 * 响应数据
	 */
	@ApiModelProperty(value = "响应数据")
	private T data;

	/**
	 * 其它响应数据
	 */
	@ApiModelProperty(value = "其它响应数据")
	private Object otherData;

	/**
	 * 枚举返回
	 * 
	 * @param resultEnum
	 * @return
	 */
	public static ResultDto responseResult(ResultEnum resultEnum) {
		ResultDto resultDto = new ResultDto();
		resultDto.setResult(resultEnum.getResult());
		resultDto.setMsg(resultEnum.getMsg());
		return resultDto;
	}

	/**
	 * 成功，返回数据
	 * 
	 * @return
	 */
	public static ResultDto succesResult() {
		ResultDto resultDto = responseResult(ResultEnum.SUCCESS);
		return resultDto;
	}

	/**
	 * 成功，返回数据
	 * 
	 * @param data
	 * @return
	 */
	public static ResultDto succesResult(Object data) {
		ResultDto resultDto = responseResult(ResultEnum.SUCCESS);
		resultDto.setData(data);
		return resultDto;
	}

	/**
	 * 成功，返回数据
	 *
	 * @param data
	 * @return
	 */
	public static ResultDto succesResultData(Object data) {
		ResultDto resultDto = responseResult(ResultEnum.SUCCESS);
		resultDto.setData(data);
		return resultDto;
	}

	/**
	 * 成功,返回msg
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultDto succesResult(String msg) {
		ResultDto resultDto = new ResultDto(ResultEnum.SUCCESS.getResult(), msg);
		return resultDto;
	}

	/**
	 * 错误，返回数据
	 * 
	 * @param data
	 * @return
	 */
	public static ResultDto errorResult(Object data) {
		ResultDto resultDto = responseResult(ResultEnum.ERROR);
		resultDto.setData(data);
		return resultDto;
	}

	/**
	 * 错误
	 * 
	 * @return
	 */
	public static ResultDto errorResult() {
		ResultDto resultDto = responseResult(ResultEnum.ERROR);
		return resultDto;
	}

	/**
	 * 错误，返回msg
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultDto errorResult(String msg) {
		ResultDto resultDto = new ResultDto(ResultEnum.ERROR.getResult(), msg);
		return resultDto;
	}

	/**
	 * 返回 code,msg
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static ResultDto responseResult(String code, String msg) {
		ResultDto resultDto = new ResultDto(code, msg);
		return resultDto;
	}

	/**
	 * code,msg,obj
	 * 
	 * @param code
	 * @param msg
	 * @param obj
	 * @return
	 */
	public static ResultDto responseResult(String code, String msg, Object obj) {
		ResultDto resultDto = new ResultDto(code, msg, obj);
		return resultDto;
	}

	public ResultDto(String result, String msg, T data) {
		this.result = result;
		this.msg = msg;
		this.data = data;
	}

	public ResultDto(String result, String msg) {
		this.result = result;
		this.msg = msg;
	}

	public ResultDto() {
	}
}
