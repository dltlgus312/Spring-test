package com.Study_03.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Study_03.board.dao.UserBoardDao;
import com.Study_03.board.dao.UserBoardHistoryDao;

@Service
public class UserBoardServiceImpl implements UserBoardService{
	
	@Autowired
	UserBoardDao userBoardDao;
	
	@Autowired
	UserBoardHistoryDao userBoardHistoryDao;
	
	@Autowired
	FileUploadService fileUploadService;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userBoardDao.selectBoardList(map);
	}

	@Override
	public int selectBoardCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userBoardDao.selectBoardCount(map);
	}

	@Override
	public Map<String, Object> selectBoardContents(int number) {
		// TODO Auto-generated method stub
		return userBoardDao.selectBoardContents(number);
	}
	

	@Override
	public List<Map<String, Object>> searchBoard(String keyword) {
		// TODO Auto-generated method stub
		return userBoardDao.searchBoard(keyword);
	}

	@Override
	public int insertBoard(Map<String, Object> map, ServletContext servletContext, MultipartFile[] multipartFile) {
		userBoardDao.insertBoard(map);
		
		int boardSn = userBoardDao.selectLastSn();
		map.put("NOTICE_SN", boardSn);
		
		userBoardHistoryDao.insertBoardHistoryGener(map);
		
		// 파일
		map.put("NOTICE_SN", boardSn);
		map.put("context", servletContext); 
		fileUploadService.insertFile(map, multipartFile);
		
		return boardSn;
	}

	@Override
	public int updateBoard(Map<String, Object> map, ServletContext servletContext, MultipartFile[] multipartFile) {
		userBoardDao.updateBoard(map);
		
		map.put("tableNm", "BOARD");
		map.put("context", servletContext); 
		fileUploadService.updateFile(map, multipartFile);
		
		return 0;
	}

	@Override
	public int deleteBoard(int number, ServletContext servletContext) {
		userBoardDao.deleteBoard(number);
		fileUploadService.deleteFile(number, servletContext);
		
		return 0;
	}
	
}
