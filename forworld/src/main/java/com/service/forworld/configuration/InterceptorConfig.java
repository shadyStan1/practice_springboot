package com.service.forworld.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.service.forworld.interceptor.JwtValidatorInterceptor;

@EnableWebMvc
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	JwtValidatorInterceptor jwtInterceptor;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(jwtInterceptor).addPathPatterns("http:/localhost:1010/validate", "/users/record");
	   }
}
