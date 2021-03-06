package com.jwt.practice.jwtdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.practice.jwtdemo.models.ApplicationUser;
import com.jwt.practice.jwtdemo.repositories.ApplicationUserRepository;

	@RestController
	@RequestMapping("/users")
	public class UserController {
		@Autowired
	    private ApplicationUserRepository applicationUserRepository;
	    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	    @PostMapping("/record")
	    public void signUp(@RequestBody ApplicationUser user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        applicationUserRepository.save(user);
	    	//return "Hello to this";
	    }
}
