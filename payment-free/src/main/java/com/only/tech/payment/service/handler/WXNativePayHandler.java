package com.only.tech.payment.service.handler;

import com.only.tech.payment.common.constant.WXPayConstants;
import com.only.tech.payment.wxsdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WXNativePayHandler {


    /**
     * 生成微信支付二维码
     * @param productId
     * @return
     */
    public String createNativeCode(Long productId) throws Exception {

        StringBuilder nativeCode=new StringBuilder("weixin：//wxpay/bizpayurl?");
        Map<String, String> condition = new HashMap<String, String>();

        //公众账号ID
        String appid=WXPayConstants.APP_ID;
        nativeCode.append("appid=").append(appid).append("&");
        condition.put("appid",appid);

        //商户号
        String mch_id=WXPayConstants.MCH_ID;
        nativeCode.append("mch_id=").append(mch_id).append("&");
        condition.put("mch_id",mch_id);

        //随机字符串
        String nonce_str=WXPayUtil.generateNonceStr();
        nativeCode.append("nonce_str=").append(nonce_str).append("&");
        condition.put("nonce_str",nonce_str);

        //千阅产品ID
        String product_id=productId+"";
        nativeCode.append("product_id=").append(product_id).append("&");
        condition.put("product_id",product_id);

        //时间戳
        Long time_stamp=WXPayUtil.getCurrentTimestampMs();
        nativeCode.append("time_stamp=").append(time_stamp).append("&");
        condition.put("time_stamp",time_stamp+"");

        //签名
        String sign = WXPayUtil.generateSignature(condition , WXPayConstants.API_KEY);
        nativeCode.append("sign=").append(sign);

        return nativeCode.toString();
    }



    public static void main(String[] args) {
        String filename=RandomStringUtils.randomAlphanumeric(20);
        System.out.println(filename);
    }




}
