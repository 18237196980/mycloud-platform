package com.zz.platform.auth.service;

import com.zz.platform.auth.constant.MessageConstant;
import com.zz.platform.auth.domain.SecurityUser;
import com.zz.platform.auth.domain.UserDto;
import com.zz.platform.auth.fegin.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现spring security的UserDetailsService接口，根据不同的clientId来加载用户信息
 */
@Service
@Slf4j
public class SmUserDetailsService implements UserDetailsService {

    @Autowired
    PayService payService;

    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        log.info("客户端clientId={}", clientId);
        UserDto userDto = null;

        String testClient = "sm-hk-admin";

        // iot基础平台
        if (testClient.equals(clientId)) {
            userDto = payService.loadUserByUsername(username);
            log.info("查询userDto={}", userDto);
        }

        if (userDto == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }

}
