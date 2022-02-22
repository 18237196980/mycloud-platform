package com.zzsm.platform.auth.fegin;

import com.zzsm.platform.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("sm-hk-admin")
public interface SmHkAdminService {

    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}
