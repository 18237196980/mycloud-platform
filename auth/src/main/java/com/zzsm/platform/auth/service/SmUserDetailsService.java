package com.zzsm.platform.auth.service;

import com.zzsm.platform.auth.constatnt.MessageConstant;
import com.zzsm.platform.auth.domain.SecurityUser;
import com.zzsm.platform.auth.fegin.*;
import com.zzsm.platform.constant.AuthConstant;
import com.zzsm.platform.domain.UserDto;
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
public class SmUserDetailsService implements UserDetailsService {

    @Autowired
    SmIotAdminService smIotAdminService;
    @Autowired
    SmNyAdminService smNyAdminService;
    @Autowired
    SmHkAdminService smHkAdminService;
    @Autowired
    SmartDeviceAdminService smartDeviceAdminService;
    @Autowired
    LkWebService lkWebService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto = null;


        // iot基础平台
        if (AuthConstant.IOT_ADMIN_CLIENT_ID.equals(clientId)) {
            userDto = smIotAdminService.loadUserByUsername(username);
        }
        // 农业管理平台
        else if (AuthConstant.NY_ADMIN_CLIENT_ID.equals(clientId) || AuthConstant.NY_PL_PAD_CLIENT_ID.equals(clientId)) {
            userDto = smNyAdminService.loadUserByUsername(username);
        }
        // 环控管理平台
        else if (AuthConstant.HK_ADMIN_CLIENT_ID.equals(clientId) || AuthConstant.HK_APP_CLIENT_ID.equals(clientId)) {
            userDto = smHkAdminService.loadUserByUsername(username);
        }
        // 智能设备管理平台
        else if (AuthConstant.SMART_DEVICE_APP_CLIENT_ID.equals(clientId)) {
            userDto = smartDeviceAdminService.loadUserByUsername(username);
        }
        // 智慧粮库管理平台
        else if (AuthConstant.LK_WEB_CLIENT_ID.equals(clientId)) {
            userDto = lkWebService.loadUserByUsername(username);
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
