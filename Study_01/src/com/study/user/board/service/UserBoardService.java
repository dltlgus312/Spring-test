package com.study.user.board.service;

import java.util.List;
import java.util.Map;

public interface UserBoardService {
	
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map);
	
	public int selectBoardCount(Map<String, Object> map);
	
	public Map<String, Object> selectBoardContents(int number);
	
	public List<Map<String, Object>> searchBoard(String keyword);
	
	public int insertBoard(Map<String, Object> map);
	
	public int updateBoard(Map<String, Object> map);
	
	public int deleteBoard(int number);
}
