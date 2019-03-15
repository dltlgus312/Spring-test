package com.study.user.main.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserMainController {

	@RequestMapping("/user/main/userMainPage.do")
	public String userMainPage( @RequestParam Map<String, Object> paramMap, ModelMap modelMap ){

		System.out.println( "paramMap ::: " + paramMap );
		
		modelMap.put( "testData", paramMap.get("id") );
		
		return "/user/main/userMainPage";
	}

	@RequestMapping("/user/main/userMainPage_.do")
	public String userMainPage_( @RequestParam Map<String, Object> paramMap, ModelMap modelMap ){
		return "/user/main/userMainPage_";
	}
	
}
