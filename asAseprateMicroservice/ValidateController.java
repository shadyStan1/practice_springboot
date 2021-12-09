package com.jwt.practice.jwtdemo.controllers;

import static com.jwt.practice.jwtdemo.constants.SecurityConstants.HEADER_NAME;
import static com.jwt.practice.jwtdemo.constants.SecurityConstants.KEY;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/validate")
public class ValidateController {

	@PostMapping
    public ResponseEntity<String> validateToken(HttpServletRequest request) {

		String token = request.getHeader(HEADER_NAME); 
		Claims user = null;
        if (token != null) {
        	try {
             user = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        	}
        	catch(Exception e) {
        		return new ResponseEntity<String>("Token invalid", HttpStatus.FORBIDDEN);
        	}
        	SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()));
        	return new ResponseEntity<String>("If your are reading this you reached a secure endpoint", HttpStatus.OK);
        }
        else
        	return new ResponseEntity<String>("Token not present in header", HttpStatus.FORBIDDEN);
    }
	
	
}
