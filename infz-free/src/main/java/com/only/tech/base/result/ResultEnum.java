package com.only.tech.base.result;

import lombok.Getter;

@Getter
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误",""),
    SUCCESS(0, "成功","success"),
    ERROR(1, "失败","error"),
    ;
    private Integer code;
    private String msg;
    private String result;

    ResultEnum(Integer code, String msg, String result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }
}
