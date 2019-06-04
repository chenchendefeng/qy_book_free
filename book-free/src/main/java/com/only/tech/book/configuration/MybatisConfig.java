package com.only.tech.book.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.only.tech.book.mapper")
public class MybatisConfig {

}
