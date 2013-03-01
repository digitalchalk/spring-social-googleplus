package com.digitalchalk.social.googleplus.webtest.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

import com.digitalchalk.social.googleplus.webtest.common.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={ "com.digitalchalk.social.googleplus" }, excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=Configuration.class),@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,value=AccountRepository.class)})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolver.setOrder(1);
		return resolver;
	}
	
}
