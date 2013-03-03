package com.digitalchalk.social.googleplus.webtest.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecureController {

	@RequestMapping("/secure")
	public String handleRequest() {
		return "secure";
	}
	
}
