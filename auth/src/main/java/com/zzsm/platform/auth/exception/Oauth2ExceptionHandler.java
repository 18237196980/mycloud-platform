package com.zzsm.platform.auth.exception;

import com.zzsm.platform.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理Oauth2抛出的异常
 */
@ControllerAdvice
public class Oauth2ExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public CommonResult handleOauth2(OAuth2Exception e) {
        return CommonResult.failed(e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(value = AuthenticationException.class)
    public CommonResult handleAuthenticationException(AuthenticationException e) {
        return CommonResult.failed(e.getMessage());
    }

}
