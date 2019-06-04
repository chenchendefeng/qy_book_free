package ooh.chaos.controller;

import com.only.tech.base.code.ViewCode;
import com.only.tech.constant.Constants;
import com.only.tech.constant.UserRedisKeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础控制类，所有的Controller都规范继承此类，一些公用的代码后续可以在此扩展
 *
 * @version 1.0
 * @date 2018/10/12
 */
public abstract class BaseController {

    @Autowired
    private RedisTemplate redisTemplate;

    public String render_404() {
        return ViewCode.error_404;
    }

    public String render_500() {
        return ViewCode.error_500;
    }

    /**
     * 获取当前登录用户对象id
     *
     * @return
     * @author xiaoshiyilang
     * @date 2018/10/13
     */
    protected Long getCurrentUserId(HttpServletRequest request) {
        return (Long) request.getSession().getAttribute(Constants.USER_LOGIN_FLAG);
    }

    /**
     * 从redis中获取当前登录用户对象id
     *
     * @param request
     * @return
     */
    protected Long getCurrentUserIdByToken(HttpServletRequest request) {
        String tokenVal = request.getParameter(Constants.TOKEN_PARAM_KEY);
        String redisKey = UserRedisKeyConstants.USER_TOKEN + tokenVal;
        Object redisUidObj = redisTemplate.opsForValue().get(redisKey);
        String userid = redisUidObj != null ? String.valueOf(redisUidObj) : null;
        return Long.valueOf(userid);
    }

}