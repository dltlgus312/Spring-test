package com.perform.svs.websocket_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsocketController {
	
	@RequestMapping("/websocket_test.do")
	public String mainController(){
		return "websocket_test";
	}
}
