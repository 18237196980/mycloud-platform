package com.zz.platform.auth.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.platform.auth.mapper.MqttUserMapper;
import com.zz.platform.auth.model.MqttUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MqttUserService {

    @Autowired
    MqttUserMapper mqttUserMapper;

    public List<MqttUser> getList() {
        Wrapper<MqttUser> wrapper = new QueryWrapper<>();
        return mqttUserMapper.selectList(wrapper);
    }

}
