package com.only.tech.user.common.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * 用户token工具类
 * @author shutong
 * @since 2019/02/20
 */
public class TokenUtils {

    public static String generalToken() {
        String token = "TOKEN";
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            int a = random.nextInt(10);
            token = token + a;
        }
        return token;
    }

    public static String md5Token(Long uid) {
        return  DigestUtils.md5Hex( generalToken() + uid);
    }


}
