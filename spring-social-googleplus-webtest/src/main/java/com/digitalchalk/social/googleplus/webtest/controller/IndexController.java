package com.digitalchalk.social.googleplus.webtest.controller;

import javax.servlet.http.*;

import org.apache.log4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public String handleRoot(HttpServletRequest request, HttpServletResponse response) {
		return handleRequest();
	}
	
	@RequestMapping("/index")
	public String handleRequest() {
		logger.info("Log4j is working OK");
		return "index";
	}
	
	@RequestMapping("/good")
	public String handleView() {
		return "goodview";
	}
	
	
}
