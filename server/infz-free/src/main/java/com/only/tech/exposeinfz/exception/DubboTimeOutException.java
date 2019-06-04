package com.only.tech.exposeinfz.exception;

/**
 * dubbo 超时
 * @author ZHI ZUN BAO
 * @since 2018/10/30
 */
public class DubboTimeOutException extends Exception {

    public DubboTimeOutException(String message) {
        super(message);
    }

    public DubboTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }
}
