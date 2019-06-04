package com.only.tech.user.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/21
 */
@Component
@Data
public class DomainUrlConfig {

    /**
     * 服务域名
     */
    @Value("${url.domain-url}")
    private String domainUrl;
}
