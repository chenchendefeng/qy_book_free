package com.only.tech.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class QYEvnUtils {

    /**
     * 判断是否是测试环境
     * @return
     */
    public static boolean isTestEnv(){
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
