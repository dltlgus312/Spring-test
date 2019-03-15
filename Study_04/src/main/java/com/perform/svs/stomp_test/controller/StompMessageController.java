package com.perform.svs.stomp_test.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StompMessageController {
	
	/**
	 * RELEASE 4.2.0 SendTo 변수 사용가능..tq
	 */ 
	
	/* setApplicationDestinationPrefixes 이후의 URI를 지정*/
	@MessageMapping("/{id1}/{id2}")
	/* enableSimpleBroker 포함한 전체 URI를 지정*/
	@SendTo("/tester/{id1}/{id2}")
	public String mainController(String msg){
		
		System.out.println(msg);

		return msg;
		
	}
	
}
