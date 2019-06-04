package com.only.tech.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.util.HashMap;
import java.util.Map;

public class TextUtils {

    private static String host = "https://textfilter.xiaohuaerai.com";
    private static String path = "/textfilter";
    private static String method = "POST";
    private static String appcode = "eff139ae275a47c4b57c7bd352a0d425";


    /**
     * 检查文本是否能通过敏感性检测 （ 调用阿里云市场服务-反垃圾文本 ）
     * @param content
     * @return  boolean  （ true 通过  |  false 不能通过 ）
     */
    public static boolean checkText(String content){

        //设置headers
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        //设置body
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("src", content);


        try {
            /**
             * 依赖请参照 https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            String responseText=EntityUtils.toString(response.getEntity());

            JSONObject jsonObject=JSONObject.parseObject(responseText);
            ResponseObject result=(ResponseObject)JSONObject.toJavaObject(jsonObject, ResponseObject.class);
            String msg=result.getMsg();
            System.out.println(msg);

            if("正常文本".equals(msg)){
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    public static void main(String[] args) {
        String content="";
        System.out.println(checkText(content));
    }



}
