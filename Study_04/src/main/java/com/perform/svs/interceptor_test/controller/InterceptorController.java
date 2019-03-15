package com.perform.svs.interceptor_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

	@RequestMapping("/interceptor_test.do")
	public String mainController(){
		return "interceptor_test";
	}
	
}
