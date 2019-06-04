package ooh.chaos.targetMethod.impl.template;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

@Component
@Scope("prototype")
public class TemplateRequestCondition implements RequestCondition<ooh.chaos.targetMethod.impl.template.TemplateRequestCondition> {
    private int[] templates;

    public TemplateRequestCondition(int[] templates) {
        this.templates = templates;
    }

    public ooh.chaos.targetMethod.impl.template.TemplateRequestCondition combine(ooh.chaos.targetMethod.impl.template.TemplateRequestCondition other) {
        int[] allTemplates = this.mergeTemplates(other.templates);
        return new ooh.chaos.targetMethod.impl.template.TemplateRequestCondition(allTemplates);
    }

    public ooh.chaos.targetMethod.impl.template.TemplateRequestCondition getMatchingCondition(HttpServletRequest request) {
        String serverName = request.getServerName();
        int template = this.getTemplateByServerName(serverName);

        for(int i = 0; i < this.templates.length; ++i) {
            if (template == this.templates[i]) {
                return this;
            }
        }

        return null;
    }

    public int compareTo(ooh.chaos.targetMethod.impl.template.TemplateRequestCondition other, HttpServletRequest request) {
        return null != this.templates && null == other.templates ? 1 : (null == this.templates && null != other.templates ? -1 : 0);
    }

    private int getTemplateByServerName(String serverName) {
        if (serverName.equalsIgnoreCase("peer1")) {
            return 1;
        } else {
            return serverName.equalsIgnoreCase("peer2") ? 2 : 0;
        }
    }

    private int[] mergeTemplates(int[] otherTemplates) {
        if (null == otherTemplates) {
            return this.templates;
        } else {
            int[] results = new int[this.templates.length + otherTemplates.length];

            int i;
            for(i = 0; i < this.templates.length; ++i) {
                results[i] = this.templates[i];
            }

            for(i = this.templates.length; i < results.length; ++i) {
                results[i] = otherTemplates[i - this.templates.length];
            }

            return results;
        }
    }
}
