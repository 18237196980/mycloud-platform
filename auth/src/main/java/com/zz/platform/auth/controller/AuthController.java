package com.zz.platform.auth.controller;

import com.zz.platform.auth.domain.CommonResult;
import com.zz.platform.auth.domain.Oauth2TokenDto;
import com.zz.platform.auth.service.MqttUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    MqttUserService mqttUserService;

    @RequestMapping("test")
    public Object test() {
        return mqttUserService.getList();
    }

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * Oauth2获取token
     * grant_type:授权模式
     * client_id:Oauth2客户端ID
     * client_secret:Oauth2客户端秘钥
     * refresh_token:刷新token
     * username:登录用户名
     * password:登录密码
     */
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CommonResult<Oauth2TokenDto> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        String JWT_TOKEN_PREFIX = "Bearer ";
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(JWT_TOKEN_PREFIX).build();
        return CommonResult.success(oauth2TokenDto);
    }

}
