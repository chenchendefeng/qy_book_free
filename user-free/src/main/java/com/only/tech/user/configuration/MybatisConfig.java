package com.only.tech.user.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.only.tech.user.mapper")
public class MybatisConfig {

}
