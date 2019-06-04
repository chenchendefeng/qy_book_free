package ooh.chaos.configuration;

import ooh.chaos.targetMethod.apiversion.ApiVersionHandlerMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class WebMvcRegistrationsConfig extends WebMvcConfigurationSupport {
    public WebMvcRegistrationsConfig() {
    }

    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new ApiVersionHandlerMapping();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }
}
