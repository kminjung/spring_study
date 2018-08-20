package com.hola.spring.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	
	@RequestMapping("/users/signup")
	public String signup() {
		
		return "users/signup";
	}
	
	@RequestMapping("/users/info")
	public String info() {
		
		return "users/info";
	}
	
	
}
