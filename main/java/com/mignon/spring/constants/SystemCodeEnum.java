package com.mignon.spring.constants;


public enum SystemCodeEnum {

    SUCCESS(200, "成功的响应结果"),
    UNAUTHORIZED(401, "未经授权的访问"),
    SYSTEM_ERROR(500, "服务器内部错误");

    final int code;
    final String msg;

    SystemCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
