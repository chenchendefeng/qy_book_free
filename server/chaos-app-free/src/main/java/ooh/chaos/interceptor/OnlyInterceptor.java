package ooh.chaos.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.Constants;
import com.only.tech.constant.UserRedisKeyConstants;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.targetMethod.Access;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求拦截器
 *
 * @author ZHI ZUN BAO
 * @version 1.0
 * @date 2019/04/26
 */
@Slf4j
public class OnlyInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;


    // 在调用方法之前执行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        boolean isTestEvn=this.isTestEnv(); //判断是否是测试环境

        if (handler instanceof ResourceHttpRequestHandler || isTestEvn) {
            return true;
        }else {


            // 判断是否需要校验权限
            try {
                // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
                HandlerMethod handlerMethod = (HandlerMethod)handler;
                // 从方法处理器中获取出要调用的方法
                Method method = handlerMethod.getMethod();
                // 获取出方法上的Access注解
                Access access = (Access)method.getAnnotation(Access.class);
                if (access == null) {
                    return true;
                }
            } catch (Exception var12) {
                log.error("拦截器出现异常", var12.getMessage());
                return false;
            }

            // 获取会话中或者前端传过来的用户id
            Long userid = (Long)request.getSession().getAttribute(Constants.USER_LOGIN_FLAG);
            if (userid == null || "0".equals(userid)) {
                String useridStr = request.getParameter(Constants.USER_LOGIN_FLAG);
                if (StringUtils.isNotBlank(useridStr)) {
                    userid = Long.valueOf(useridStr);
                }
            }

            ResultDto resultDto = null;

            // 用户id存在
            if (userid != null && !"0".equals(userid)) {
                // 获取前端请求参数
                Map<String, String[]> parameterMap = request.getParameterMap();
                HashMap<String, String> paramsMap = getBody(request);

                // 获取前端传过来的token
                String tokenVal = (String)paramsMap.get("userToken");
                if (StringUtils.isBlank(tokenVal) && parameterMap != null && !parameterMap.isEmpty() && parameterMap.get("userToken") != null && ((String[])parameterMap.get("userToken")).length > 0) {
                    tokenVal = ((String[])parameterMap.get("userToken"))[0];
                }

                //md5加密后放入redis中
                String md5Key = DigestUtils.md5Hex(Constants.TOKEN_KEY_PRE + userid);
                String tokenKey = UserRedisKeyConstants.USER_TOKEN + md5Key;
                Object redisTokenObj = this.redisTemplate.opsForValue().get(tokenKey);
                String redisToken = redisTokenObj != null ? String.valueOf(redisTokenObj) : null;
                if (tokenVal != null && redisToken != null && tokenVal.equals(redisToken)) {
                    // 转移到下一个拦截器
                    return super.preHandle(request, response, handler);
                } else {
                    log.info("token不存在或失效");
                    log.info("tokenVal={};redisToken={};!tokenVal.equals(redisToken)={}", new Object[]{tokenVal, redisToken, !tokenVal.equals(redisToken)});
                    resultDto = ResultDto.responseResult("555", "登录失效");
                    response.addHeader("sessionstatus", "timeOut");
                    response.setContentType("application/json;charset=UTF-8");
                    response.getOutputStream().write(JSONObject.toJSONBytes(resultDto, new SerializerFeature[0]));
                    return false;
                }

            } else {
                // 用户id不存在直接驳回
                log.info("会话不存在或失效");
                resultDto = ResultDto.responseResult("555", "登录失效");
                response.addHeader("sessionstatus", "timeOut");
                response.setContentType("application/json;charset=UTF-8");
                response.getOutputStream().write(JSONObject.toJSONBytes(resultDto, new SerializerFeature[]{SerializerFeature.QuoteFieldNames}));
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * @param request
     * @return
     * @throws IOException
     * @author xiaoshiyilang
     */
    public static HashMap<String, String> getBody(HttpServletRequest request) throws IOException {
        HashMap<String, String> bodyMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                boolean var6 = true;

                int bytesRead;
                while((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                    String[] paramsArr = stringBuilder.toString().split("=");
                    bodyMap.put(paramsArr[0], paramsArr[1]);
                }
            }
        } catch (IOException var15) {
            throw var15;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException var14) {
                    throw var14;
                }
            }

        }

        return bodyMap;
    }

    /**
     * 判断是否是测试环境，如果是测试环境不用权限验证
     * @return
     */
    private boolean isTestEnv(){
        boolean flag=false;
        String address = null;
        try {
            address = InetAddress.getLocalHost().getHostAddress().toString();
            if(address.startsWith("192.168.") || address.startsWith("127.0.") || address.equals("localhost")){
                flag=true;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
