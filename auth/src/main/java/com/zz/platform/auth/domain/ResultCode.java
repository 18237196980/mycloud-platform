package com.zz.platform.auth.domain;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

public enum ResultCode implements IErrorCode {
    SUCCESS(1L, "操作成功"),
    FAILED(0L, "操作失败"),
    VALIDATE_FAILED(404L, "参数检验失败"),
    UNAUTHORIZED(401L, "暂未登录或token已经过期"),
    FORBIDDEN(403L, "没有相关权限");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return null;
    }

    public String getMessage() {
        return this.message;
    }
}