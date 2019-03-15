package com.perform.svs.stomp_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StompController {
	
	@RequestMapping("/stomp_test.do")
	public String mainController(){
		return "stomp_test";
	}
}
