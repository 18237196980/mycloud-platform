package com.zz.platform.auth.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.zz.platform.auth.mapper")
public class MybatisConfig extends MybatisPlusConfig {

}