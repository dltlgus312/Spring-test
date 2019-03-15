package com.study.user.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.user.board.dao.UserBoardDao;
import com.study.user.board.dao.UserBoardHistoryDao;

@Service
public class UserBoardServiceImpl implements UserBoardService{
	
	@Autowired
	UserBoardDao userBoardDao;
	
	@Autowired
	UserBoardHistoryDao userBoardHistoryDao;

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
	public int insertBoard(Map<String, Object> map) {
		userBoardDao.insertBoard(map);
		
		int boardSn = userBoardDao.selectLastSn();
		map.put("NOTICE_SN", boardSn);
		
		userBoardHistoryDao.insertBoardHistoryGener(map);
		
		return 1;
	}

	@Override
	public int updateBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userBoardDao.updateBoard(map);
	}

	@Override
	public int deleteBoard(int number) {
		// TODO Auto-generated method stub
		return userBoardDao.deleteBoard(number);
	}

	
}
