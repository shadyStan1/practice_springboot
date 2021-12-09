package com.service.forworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.forworld.service.TestService;

	@RestController
	@RequestMapping("/users/record")
	public class Controller1 {

		@Autowired
		private TestService ts;
	    @PostMapping
	    public String signUp() { 
		ts.m1();
		return null;
	    }
}

