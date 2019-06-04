package com.only.tech.activity.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.only.tech.activity.mapper")
public class MybatisConfig {

}
