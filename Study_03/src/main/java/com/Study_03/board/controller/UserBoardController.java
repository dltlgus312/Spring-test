package com.Study_03.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Study_03.board.service.FileUploadService;
import com.Study_03.board.service.UserBoardService;

@Controller
public class UserBoardController {

	@Autowired
	UserBoardService userBoardService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping("/home.do")
	public String testPage(){
		return "/home";
	}
	
	@RequestMapping(value="/user/board/userBoardList.do", method=RequestMethod.GET)
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

		return "/board/userBoardList";
	}

	@RequestMapping("/user/board/boardContents.do")
	public String boardContentsPage(HttpServletRequest request, ModelMap modelMap) {

		modelMap.addAttribute("boardContents",
				userBoardService.selectBoardContents(Integer.parseInt(request.getParameter("number"))));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("tableNm" , "BOARD");
		map.put("tableSn" , Integer.parseInt(request.getParameter("number")));
		
		modelMap.put("file", fileUploadService.selectListFile(map));
		
		return "/board/boardContents";
	}

	@RequestMapping("/user/board/boardContentsModify.do")
	public String boardContentsModifyPage(HttpServletRequest request, ModelMap modelMap) {

		String number = request.getParameter("number");

		if (number != null) {
			modelMap.addAttribute("boardContents", userBoardService.selectBoardContents(Integer.parseInt(number)));
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("tableNm" , "BOARD");
			map.put("tableSn" , Integer.parseInt(number));
			
			modelMap.put("file", fileUploadService.selectListFile(map));
		}

		return "/board/boardContentsModify";
	}

	
	
	
	
	
	
	// 생성, 수정, 삭제
	@RequestMapping( value="/user/board/modify.do", method = RequestMethod.POST )
	public @ResponseBody Map<String, Object> boardModify(HttpServletRequest request, @RequestParam Map<String, Object> map, @RequestParam("file") MultipartFile[] multipartFile) {
		
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
		map.put("MOD_USER_SN", 1);
		userBoardService.updateBoard(map, request.getSession().getServletContext(), multipartFile);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		return result;
	}
	
	@RequestMapping( value = "/user/board/generator.do", method=RequestMethod.POST )
	public @ResponseBody Map<String, Object> boardGenerator(HttpServletRequest request, @RequestParam Map<String, Object> map,@RequestParam("file") MultipartFile[] multipartFile) {
		Map<String, Object> result = new HashMap<String, Object>();
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
		map.put("tableNm", "BOARD");
		
		int sn = userBoardService.insertBoard(map, request.getSession().getServletContext(), multipartFile);
		
		result.put("sn", sn);
		return result;
	}

	@RequestMapping("/user/board/delete.do")
	public void boardDelete(HttpServletRequest request, @RequestParam String number) {
		userBoardService.deleteBoard(Integer.parseInt(number), request.getSession().getServletContext());
	}
	
}
