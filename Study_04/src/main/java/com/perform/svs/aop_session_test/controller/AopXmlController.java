package com.perform.svs.aop_session_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AopXmlController {
	@RequestMapping("/aop_xml_test.do")
	public String mainController(){
		return "aop_xml_test";
	}
}
