package com.jwt.practice.jwtdemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.jwt.practice.jwtdemo.security.AuthenticationFilter;
import com.jwt.practice.jwtdemo.security.AuthorizationFilter;
//import com.jwt.practice.jwtdemo.services.ApplicationUserDetailsService;

import static com.jwt.practice.jwtdemo.constants.SecurityConstants.*;
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private ApplicationUserDetailsService userDetailsService;
	//private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//	public SecurityConfiguration(ApplicationUserDetailsService userDetailsService,
//			BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.userDetailsService = userDetailsService;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}

	/**
	 * backup if end points and validation happen in same service
	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,VALIDATE_TOKEN_URL).permitAll()
//				.anyRequest().authenticated().and().addFilter(new AuthenticationFilter(authenticationManager()))
//				.addFilter(new AuthorizationFilter(authenticationManager())).sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}

	/**
	 * if only validation of jwt happens in this service
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,VALIDATE_TOKEN_URL).permitAll()
				.anyRequest().authenticated().and().addFilter(new AuthenticationFilter(authenticationManager()))
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
//	@Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }

}
