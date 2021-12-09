//package com.service.forworld.aspect;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//@Aspect  
//@Component  
//public class AspectService {
//
//	
////	@Pointcut("execution(* com.service.forworld.service.TestService.*(..)))")
////    public void signUp() {};
//    
//	@Before("execution(* com.service.forworld.service.TestService.*(..)))")  
//	public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {  
//		System.out.println("Before method:" + joinPoint.getSignature());  
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).
//				getRequest();
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Authorization", request.getHeader("Authorization"));
//		HttpEntity<String> entity = new HttpEntity<>("body", headers);
//
//		   ResponseEntity<String> obj=  new RestTemplate().exchange("http://localhost:1010/api/secure", HttpMethod.GET, entity, String.class);
//
//		}  
//}
