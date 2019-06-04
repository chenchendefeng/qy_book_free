package com.only.tech.base.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/10
 */
@Slf4j
public class MD5Util {



    public static String md5(String data){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] array = md.digest(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            data = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            log.error("get md5 string error :",e);
        }
        return data;
    }
}
