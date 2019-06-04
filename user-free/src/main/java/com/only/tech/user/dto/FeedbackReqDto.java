package com.only.tech.user.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FeedbackReqDto {

	/**
	 * 用户ID
	 */
	@NotNull(message = "用户id不能为空")
	private Long cuId;

	/**
	 * 反馈内容
	 */
	@NotBlank(message = "反馈内容不能为空")
	@Length(min = 1, max = 200, message = "反馈内容不能超过200个字符")
	private String content;

	@NotNull(message = "反馈内容类型不能为空")
	@Min(value = 1, message = "反馈内容类型只能为1或者2")
	@Max(value = 2, message = "反馈内容类型只能为1或者2")
	private Integer contentType;

	/**
	 * QQ号码
	 */
	@Length(min = 0, max = 15, message = "QQ号码不能超过15位")
	private String qq;

	/**
	 * 联系电话
	 */
	@Length(min = 0, max = 20, message = "联系电话不能超过20位")
	private String phone;
}
