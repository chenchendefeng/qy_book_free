package ooh.chaos.targetMethod.impl.template;

import java.lang.reflect.Method;
import ooh.chaos.targetMethod.Template;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class TemplateHandlerMapping extends RequestMappingHandlerMapping {
    public TemplateHandlerMapping() {
    }

    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        method.setAccessible(true);
        Template template = (Template)method.getAnnotation(Template.class);
        int[] templates = null == template ? new int[0] : template.value();
        return (RequestCondition)this.obtainApplicationContext().getBean(RequestCondition.class, new Object[]{templates});
    }
}