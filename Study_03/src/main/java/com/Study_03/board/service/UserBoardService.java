package com.Study_03.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

public interface UserBoardService {
	
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map);
	
	public int selectBoardCount(Map<String, Object> map);
	
	public Map<String, Object> selectBoardContents(int number);
	
	public List<Map<String, Object>> searchBoard(String keyword);
	
	public int insertBoard(Map<String, Object> map, ServletContext servletContext, MultipartFile[] multipartFile);
	
	public int updateBoard(Map<String, Object> map, ServletContext servletContext, MultipartFile[] multipartFile);
	
	public int deleteBoard(int number,ServletContext servletContext);
}
