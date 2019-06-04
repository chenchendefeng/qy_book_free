package ooh.chaos.targetMethod.apiversion;

import ooh.chaos.targetMethod.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class ApiVersionHandlerMapping extends RequestMappingHandlerMapping {
    public ApiVersionHandlerMapping() {
    }

    protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {
        ApiVersion apiVersion = (ApiVersion)AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return this.createCondition(apiVersion);
    }

    protected RequestCondition<ApiVersionCondition> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = (ApiVersion)AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return this.createCondition(apiVersion);
    }

    private RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
    }
}
