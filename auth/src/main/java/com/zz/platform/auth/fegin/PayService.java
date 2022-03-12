package com.zz.platform.auth.fegin;

import com.zz.platform.auth.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("platform-pay-service")
public interface PayService {

    @GetMapping("/loadUserByUsername")
    UserDto loadUserByUsername(@RequestParam String username);

}
