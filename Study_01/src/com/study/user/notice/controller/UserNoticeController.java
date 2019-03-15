package com.study.user.notice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.user.notice.service.UserNoticeService;

@Controller
public class UserNoticeController {

	@Autowired
	UserNoticeService userNoticeService;
	
	@RequestMapping("/user/notice/userNoticeListPage.do")
	public String userNoticeListPage( @RequestParam Map<String, Object> paramMap, ModelMap modelMap ){

		Map<String, Object> commandMap = new HashMap<String, Object>();
		modelMap.put( "noticeList", userNoticeService.selectNoticeList( commandMap ) );
		
		return "/user/notice/userNoticeListPage";
	}
	
}
