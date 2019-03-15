package com.Study_03.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService { 
	public int insertFile(Map<String, Object> map, MultipartFile[] multipartFile);
	public int updateFile(Map<String, Object> map, MultipartFile[] multipartFile);
	public Map<String, Object> selectFile(Map<String, Object> map);
	public List<Map<String, Object>> selectListFile(Map<String, Object> map);
	public void deleteFile(int number, ServletContext context);
}
