package com.zz.platform.service2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

    @RequestMapping("test")
    public Object test() {
        return "支付业务2controller";
    }

}
