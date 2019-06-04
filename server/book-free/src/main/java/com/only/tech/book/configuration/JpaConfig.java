package com.only.tech.book.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.only.tech.book.doc")
public class JpaConfig {
}
