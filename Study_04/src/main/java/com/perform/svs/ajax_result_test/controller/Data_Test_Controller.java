package com.perform.svs.ajax_result_test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Data_Test_Controller {

	@RequestMapping("/ajax_result_test.do")
	public String homeControl(){
		return "ajax_result_test";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax_request.do", method=RequestMethod.POST)
	public  Map<String, Object> homeActionControl(@RequestParam Map<String, Object> map){
		
		System.out.println(map.toString());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		
		return result;
	}
}
