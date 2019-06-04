package com.only.tech.payment.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.only.tech.payment.mapper")
public class MybatisConfig {

}
