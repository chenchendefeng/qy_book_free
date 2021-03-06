package com.only.tech.base;

import lombok.Data;

/**
 * QQ用户信息响应实体
 * 
 * @author xiaoshiyilang
 * @date 2018/10/17
 * @version 1.0
 */
@Data
public class QQUserInfoDto {

	/**
	 * 返回码
	 */
	private Integer ret;
	/**
	 * 如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
	 */
	private String msg;
	/**
	 * 用户在QQ空间的昵称。
	 */
	private String nickname;
	/**
	 * 大小为30×30像素的QQ空间头像URL。
	 */
	private String figureurl;
	/**
	 * 大小为50×50像素的QQ空间头像URL。
	 */
	private String figureurl_1;
	/**
	 * 大小为100×100像素的QQ空间头像URL。
	 */
	private String figureurl_2;
	/**
	 * 大小为40×40像素的QQ头像URL。
	 */
	private String figureurl_qq_1;
	/**
	 * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
	 */
	private String figureurl_qq_2;
	/**
	 * 性别。 如果获取不到则默认返回"男"
	 */
	private String gender;

}
