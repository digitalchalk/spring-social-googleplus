package com.digitalchalk.social.googleplus.webtest.config;

import javax.servlet.*;

import org.springframework.web.filter.*;
import org.springframework.web.servlet.support.*;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcConfig.class, SecurityServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/view/*", "/index", "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new DelegatingFilterProxy("springSecurityFilterChain"), new HiddenHttpMethodFilter() };
	}

}
