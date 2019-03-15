package com.study.user.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.user.board.service.UserBoardService;

@Controller
public class UserBoardController {

	@Autowired
	UserBoardService userBoardService;
	
	
	@RequestMapping("/user/board/test.do")
	public String testPage(){
		return "/user/board/test";
	}

	
	@RequestMapping("/user/board/userBoardList.do")
	public String boardListPage(ModelMap modelMap, HttpServletRequest request) {
		
		String bundle = request.getParameter("bundle");
		String page = request.getParameter("page");
		String search = request.getParameter("search");

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);

		if(bundle == null){
			bundle = "10";
			page = "1";
		}
		
		map.put("bundle", Integer.parseInt(bundle));
		map.put("page",  Integer.parseInt(page));
		
		modelMap.put("boardList", userBoardService.selectBoardList(map));
		modelMap.put("cnt", userBoardService.selectBoardCount(map));
		
		modelMap.put("search", map.get("search"));
		modelMap.put("bundle", map.get("bundle"));
		modelMap.put("page", map.get("page"));

		return "/user/board/userBoardList";
	}

	@RequestMapping("/user/board/boardContents.do")
	public String boardContentsPage(HttpServletRequest request, ModelMap modelMap) {

		modelMap.addAttribute("boardContents",
				userBoardService.selectBoardContents(Integer.parseInt(request.getParameter("number"))));

		return "/user/board/boardContents";
	}

	@RequestMapping("/user/board/boardContentsModify.do")
	public String boardContentsModifyPage(HttpServletRequest request, ModelMap modelMap) {

		String number = request.getParameter("number");

		if (number != null) {
			modelMap.addAttribute("boardContents", userBoardService.selectBoardContents(Integer.parseInt(number)));
		}

		return "/user/board/boardContentsModify";
	}

	
	
	// 생성, 수정, 삭제
	@RequestMapping("/user/board/modify.do")
	public void boardModify(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		
		String ip = request.getHeader("X-FORWARDED-FOR");

		// proxy 환경일 경우
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		// 웹로직 서버일 경우
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		
		map.put("MOD_IP", ip);
		userBoardService.updateBoard(map);
	}

	@RequestMapping("/user/board/generator.do")
	public void boardGenerator(@RequestParam Map<String, Object> map, HttpServletRequest request) {

		String ip = request.getHeader("X-FORWARDED-FOR");

		// proxy 환경일 경우
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		// 웹로직 서버일 경우
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		
		map.put("REG_IP", ip);
		map.put("MOD_IP", ip);
		map.put("REG_USER_SN", 1);
		
		userBoardService.insertBoard(map);
	}

	@RequestMapping("/user/board/delete.do")
	public void boardDelete(@RequestParam String number) {
		userBoardService.deleteBoard(Integer.parseInt(number));
	}

}
