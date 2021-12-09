package com.service.forworld.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtValidatorInterceptor implements HandlerInterceptor{

	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", request.getHeader("Authorization"));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);

		   ResponseEntity<String> obj=  new RestTemplate().exchange("http://localhost:1010/validate", HttpMethod.POST, entity, String.class);
	       if(obj.getStatusCode().equals(HttpStatus.OK))
		   return true;
	       else return false;
	   }
}
