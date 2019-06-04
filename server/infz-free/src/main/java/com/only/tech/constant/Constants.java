package com.only.tech.constant;

/**
 * 全局通用常量类
 * 
 * @author xiaoshiyilang
 * @date 2018/10/13
 * @version 1.0
 */
public interface Constants {

	String STR_SUCCESS = "SUCCESS";
	String STR_FAIL = "FAIL";

	/** session中的用户id键值 */
	String USER_LOGIN_FLAG = "uid";

	/** OSS服务器域名 */
	String OSS_IPADDR = "http://qy-pic.oss-cn-shenzhen.aliyuncs.com";

	/** 问题反馈图像上传库 */
	String FEEDBACK_PICTURE_LIB = "feedback/";


	String BOOK_COVER = "book/";

	/** OSS路径（开屏页） */
	String OSS_STARTPAGE = "startPage/";
	
	/** OSS路径（弹窗页）*/
	String OSS_POPUP_WINDOW = "popupWindow/";

	/** OSS路径（用户头像库） */
	String USERHEAD_PICTURE_LIB = "/head";

	/** 用户默认头像名称 */
	String DEFAULT_USER_HEADPIC = "default.png";

	/** 用户头像存放路径 */
	String USER_IMAGE_STORAGE_PATH = OSS_IPADDR + USERHEAD_PICTURE_LIB + "/";

	/** 用户默认头像文件访问地址 */
	String USER_DEFAULT_HEADER_PATH = OSS_IPADDR + USERHEAD_PICTURE_LIB + "/" + DEFAULT_USER_HEADPIC;

	/** 用户昵称前缀 */
	String NAME_PREFIX = "爱读";

	/** 用户游客前缀 */
	String NAME_PREFIX_VISITOR = "游客";



	/** 用户状态 */
	String USER_STATUS_NORMAL = "normal"; //正常状态
	String USER_STATUS_FROZEN= "frozen"; //封号状态
	String USER_STATUS_FROZENBYIMEI = "frozenByImei"; //封设备状态
	String USER_STATUS_DRAWDOWN = "drawdown"; //注销状态


	/** token接收前端参数key */
	String TOKEN_PARAM_KEY = "userToken";

	/** token key的前缀 */
	String TOKEN_KEY_PRE = "USERTOKEN";

	/** 系统超级管理员 */
	String SYSTEM_ADMIN = "systemAdmin";

	/** 项目上线时间 */
	String PROJECT_ONLINE_TIME = "2018-11-07";


	/** 系统配置类型*/
	String EXCHANGE_RATIO = "exchangeRatio";//兑换比例

}
