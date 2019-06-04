package com.only.tech.user.service.facade;

import com.alibaba.fastjson.JSONObject;
import com.only.tech.base.QYEvnUtils;
import com.only.tech.base.WxUserInfoDto;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.Constants;
import com.only.tech.constant.CustomerTypeConstants;
import com.only.tech.constant.UserRedisKeyConstants;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.user.common.enums.MobCheckStatusEnum;
import com.only.tech.user.common.utils.EmojiUtils;
import com.only.tech.user.service.biz.CustomerAccountService;
import com.only.tech.user.service.biz.CustomerBizService;
import com.only.tech.user.service.biz.CustomerService;
import com.only.tech.user.service.handler.LoginCheckThreadManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author shutong
 * @since 2019/04/30
 */
@Slf4j
@Service
public class LoginFacade {

    @Autowired
    private LoginCheckThreadManager loginCheckThreadManager;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private CustomerBizService customerBizService;


    /**
     * 手机注册
     * @param phone
     * @param imei
     * @param clientType
     * @param channel
     * @return
     */
    private Customer registerByPhone(String phone, String imei, String clientType, String channel) {
        // 注册一个新用户绑定手机号码
        Customer customer = new Customer();
        customer.setBindPhone(phone);
        customer.setAvatar(Constants.USER_DEFAULT_HEADER_PATH);
        customer.setNickName(Constants.NAME_PREFIX + phone.substring(phone.length() - 4));
        customer.setCuName(phone);
        customer.setImei(imei);
        customer.setSource(clientType);
        customer.setUserType(CustomerTypeConstants.USER_TYPE_REGISTER);
        customer.setRegistChannel(channel);
        customer.setRegDate(new Date());
        this.customerService.save(customer);
        return customer;
    }

    private Map<String, Object> getResultMap(Customer customer, boolean isRegister) {

        Long cuid = customer.getCuId();
        String md5Key = DigestUtils.md5Hex(Constants.TOKEN_KEY_PRE + cuid);
        String md5Token = DigestUtils.md5Hex(generalToken() + cuid);
        if(CustomerTypeConstants.USER_TYPE_VISITOR.equals(customer.getUserType())){
            md5Token = CustomerTypeConstants.USER_TYPE_VISITOR + md5Token;
        }
        redisTemplate.delete(md5Token);

        // 返回给前端的Token
        String tokenKey = UserRedisKeyConstants.USER_TOKEN + md5Key;
        redisTemplate.opsForValue().set(tokenKey, md5Token,30, TimeUnit.DAYS);

        // 记录成功的用户id
        String uidKey = UserRedisKeyConstants.USER_TOKEN + md5Token;
        redisTemplate.opsForValue().set(uidKey, customer.getCuId(),30,TimeUnit.DAYS);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("userInfo", customer);
        resultMap.put("userToken", md5Token);
        resultMap.put("isRegister",isRegister);

        return resultMap;
    }

    /**
     * 校验用户状态
     * @param userStatus
     * @return
     */
    public ResultDto checkStatus(String userStatus){
        if(Constants.USER_STATUS_DRAWDOWN.equals(userStatus)){
            return ResultDto.errorResult("用户被注销");
        }else if(Constants.USER_STATUS_FROZEN.equals(userStatus)){
            return ResultDto.errorResult("用户账户被冻结");
        }else if(Constants.USER_STATUS_FROZENBYIMEI.equals(userStatus)){
            return ResultDto.errorResult("用户设备被冻结");
        }
        return null;
    }


    /**
     * 一般的Token
     * @date 2018/10/19
     * @return
     */
    private String generalToken() {
        StringBuffer sb = new StringBuffer();
        sb.append("TOKEN");
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            int a = random.nextInt(10);
            sb.append(a);
        }
        return sb.toString();
    }

    /**
     * 微信登录
     * @param code
     * @param imei
     * @param source
     * @param channel
     * @param request
     * @return
     */
    public ResultDto loginByWechat(String code, String imei, String source, String channel, HttpServletRequest request) {

        WxUserInfoDto wxUserInfoDto = loginCheckThreadManager.queryWXUserInfoDto(code);
        String openId = wxUserInfoDto.getOpenid();
        if(StringUtils.isEmpty(openId)){
            log.error("wechatLogin get an empty WxUserInfoDto,code={},imei={},channel={}",code,imei,channel);
            return ResultDto.errorResult("获取微信信息失败");
        }
        // 根据openid查询数据库用户信息
        Customer customer = customerService.selectByBindOpenid(wxUserInfoDto.getOpenid());

        boolean isRegister = false;
        if (customer == null){  //注册
            boolean forzenFlag=this.customerService.checkForzenByImei(imei); //判断设备好是否被封
            if(forzenFlag){
                return ResultDto.errorResult("您的设备已被冻结");
            }
            //注册新用户
            registerByWechat(wxUserInfoDto,imei,source,channel);
            //初始化账户信息
            customer =this.customerService.selectByBindOpenid(openId);
            if(customer!=null){
                customerAccountFacade.creat(customer.getCuId());
                customerBizService.initCustomerBiz(customer.getCuId());
            }

            isRegister = true;
        }else {
            //判断用户状态
            String userStatus=customer.getUserStatus();
            ResultDto resultDto = checkStatus(userStatus);
            if (resultDto != null){
                return resultDto;
            }
        }

        //将用户信息存入session
        Long uid = customer.getCuId();
        request.getSession().setAttribute(Constants.USER_LOGIN_FLAG, uid);

        //返回用户信息和token
        Map<String, Object> resultMap = getResultMap(customer,isRegister);

        return ResultDto.succesResult(resultMap);
    }

    /**
     * 微信注册 (注册一个新用户绑定openid)
     * @param wxUserInfoDto
     * @param imei
     * @param source
     * @param channel
     * @return
     */
    private Customer registerByWechat(WxUserInfoDto wxUserInfoDto, String imei, String source, String channel) {
        Customer customer = new Customer();
        customer.setBindOpenid(wxUserInfoDto.getOpenid());
        String name = EmojiUtils.filterEmoji(wxUserInfoDto.getNickname()); // 过滤特殊字符或者表情转换成？号
        customer.setNickName(name);
        customer.setSex(wxUserInfoDto.getSex());
        customer.setAddress(wxUserInfoDto.getCountry() + wxUserInfoDto.getProvince() + wxUserInfoDto.getCity());
        customer.setAvatar(wxUserInfoDto.getHeadimgurl());
        customer.setImei(imei);
        customer.setSource(source);
        customer.setUserType(CustomerTypeConstants.USER_TYPE_REGISTER); //注册类型的用户
        customer.setRegistChannel(channel);
        customer.setRegDate(new Date());
        this.customerService.save(customer);
        return customer;
    }

    /**
     * 手机登录
     * @param phone
     * @param zone
     * @param code
     * @param imei
     * @param source
     * @param channel
     * @param request
     * @return
     */
    public ResultDto loginByPhone(String phone, String zone, String code, String imei, String source, String channel, HttpServletRequest request) {

        // 请求mob接口验证短信验证码是否正确
        String result = loginCheckThreadManager.checkMobCode(phone, zone, code);
        if(result == null){
            log.error("checkMobCode gen an empty result phone={}",phone);
            return ResultDto.errorResult("验证错误");
        }
        JSONObject obj = JSONObject.parseObject(result);
        Integer status = obj.getInteger("status");

        //测试环境去掉验证码校验
        boolean isTestEvn= QYEvnUtils.isTestEnv(); //判断是否是测试环境
        if(isTestEvn){
            status = 200;
        }
        if (status == 200 || isTestAccount(phone, code)) {

            Customer customer = this.customerService.selectByBindPhone(phone);

            boolean isRegister = false;
            if (customer == null) {
                //判断设备好是否被封
                boolean forzenFlag=this.customerService.checkForzenByImei(imei);
                if(forzenFlag){
                    return ResultDto.errorResult("您的设备已被冻结");
                }
                //注册新用户
                registerByPhone(phone,imei,source,channel);
                //初始化账号信息
                customer = this.customerService.selectByBindPhone(phone);
                if(customer!=null){
                    customerAccountFacade.creat(customer.getCuId());
                    customerBizService.initCustomerBiz(customer.getCuId());
                }

                isRegister = true;
            }else {
                //判断用户状态
                String userStatus=customer.getUserStatus();
                ResultDto resultDto = checkStatus(userStatus);
                if (resultDto != null){
                    return resultDto;
                }
            }

            //将用户信息存入session
            Long uid = customer.getCuId();
            request.getSession().setAttribute(Constants.USER_LOGIN_FLAG, uid);

            //返回用户信息和token
            Map<String, Object> resultMap = getResultMap(customer, isRegister);

            return ResultDto.succesResult(resultMap);
        }

        String msg = "";
        try {
            MobCheckStatusEnum statusEnum = MobCheckStatusEnum.valueOf("STATUS_" + status);
            if (statusEnum != null){
                msg = statusEnum.getMsg();
            }
        }catch (Exception e){
            log.error("验证错误：",status);
        }
        log.error("验证错误 错误码：[]，信息：[]",status,msg);
        return ResultDto.errorResult("验证错误:" + msg);
    }



    /**
     * 游客登录
     * @param imei
     * @param source
     * @param channel
     * @param request
     * @return
     */
    public ResultDto visitorLogin(String imei, String source, String channel, HttpServletRequest request) {

        Customer customer = this.customerService.queryVisitorByImei(imei); //查询是否有相同imei的游客

        if (customer == null) {  // 注册一个新游客用户
            customer = new Customer();
            customer.setAvatar(Constants.USER_DEFAULT_HEADER_PATH); // 默认头像
            customer.setNickName(Constants.NAME_PREFIX_VISITOR +"_"+imei);
            customer.setCuName(Constants.NAME_PREFIX_VISITOR +"_"+imei);
            customer.setImei(imei);
            customer.setSource(source);
            customer.setUserType(CustomerTypeConstants.USER_TYPE_VISITOR); //游客类型的用户
            customer.setRegistChannel(channel);
            customer.setRegDate(new Date());
            this.customerService.save(customer);
        }
        else { //判断用户状态
            String userStatus=customer.getUserStatus();
            ResultDto resultDto = checkStatus(userStatus);
            if (resultDto != null){
                return resultDto;
            }
        }

        //将用户信息存入session
        Long cuId = customer.getCuId();
        request.getSession().setAttribute(Constants.USER_LOGIN_FLAG, cuId);
        //返回用户信息和token
        Map<String, Object> resultMap = getResultMap(customer, false);

        return ResultDto.succesResult(resultMap);

    }

    /**
     * 是否测试账号,手机登录时会用到
     * @param phone
     * @param code
     */
    private boolean isTestAccount(String phone,String code){
        return (phone.equals(com.only.tech.user.common.constant.Constants.TEST_PHONE1)
                ||phone.equals(com.only.tech.user.common.constant.Constants.TEST_PHONE2)
                ||phone.equals(com.only.tech.user.common.constant.Constants.TEST_PHONE3))
                && code.equals(com.only.tech.user.common.constant.Constants.TEST_PASSWORD);
    }

}
