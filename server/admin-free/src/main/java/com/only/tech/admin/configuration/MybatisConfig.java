package com.only.tech.admin.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.only.tech.admin.mapper")
public class MybatisConfig {

}
