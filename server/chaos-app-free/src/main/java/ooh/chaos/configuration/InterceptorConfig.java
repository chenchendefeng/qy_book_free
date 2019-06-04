package ooh.chaos.configuration;

import ooh.chaos.interceptor.OnlyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	public InterceptorConfig() {
	}

	@Bean
	public OnlyInterceptor onlyInterceptor() {
		return new OnlyInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.onlyInterceptor())
				.addPathPatterns(new String[]{"/**"})
				.excludePathPatterns(new String[]{"/main/**"});
	}


}
