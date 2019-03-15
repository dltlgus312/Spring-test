package com.study.user.board.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.common.dao.CommonDao;

@Repository
public class UserBoardHistoryDao extends CommonDao{
	
	private String nameSpace = "userBoardHistoryDao.";

	public int insertBoardHistoryGener(Map<String, Object> map){
		return getSqlSession().insert(nameSpace+"insertBoardHistoryGener", map);
	}
	
	public int updateBoardHistoryModify(Map<String, Object> map){
		return getSqlSession().update(nameSpace + "updateBoardHistoryModify", map);
	}
	
}
