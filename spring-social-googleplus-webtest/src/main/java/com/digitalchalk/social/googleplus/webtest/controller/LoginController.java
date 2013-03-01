package com.digitalchalk.social.googleplus.webtest.controller;

import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout() {
		SecurityContextHolder.clearContext();
		return "login";
	}
}
