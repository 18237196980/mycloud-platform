package com.zz.platform.service.controller;

import com.zz.platform.service.domain.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pay")
public class PayController {

    @RequestMapping("test")
    public Object test() {
        return "支付业务controller";
    }

    @GetMapping("loadUserByUsername")
    public UserDto loadUserByUsername(String username) {
        System.out.println("查询用户..." + username);

        UserDto model = new UserDto();
        model.setUsername(username);
        model.setPassword("$2a$10$0UuNauAAby9VrP5CexcdXecoh0kZqwssaxOjAIdPbVShcAkK.vVtu");
        String testClient = "sm-hk-admin";
        model.setClientId(testClient);
        model.setId(5L);
        model.setStatus(1);
        List<String> roleList = Collections.singletonList("add,update");
        model.setRoles(roleList);

        return model;
    }

}
