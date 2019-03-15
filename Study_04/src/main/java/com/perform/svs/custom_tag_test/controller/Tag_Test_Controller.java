package com.perform.svs.custom_tag_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tag_Test_Controller {

	@RequestMapping("/custom_tag_test.do")
	public String mainController(){
		return "tag_test";
	}
}
