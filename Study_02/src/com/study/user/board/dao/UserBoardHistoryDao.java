package com.study.user.board.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserBoardHistoryDao{
	
	private String nameSpace = "userBoardHistoryDao.";
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public int insertBoardHistoryGener(Map<String, Object> map){
		return sqlSessionFactory.openSession().insert(nameSpace+"insertBoardHistoryGener", map);
	}
	
	public int updateBoardHistoryModify(Map<String, Object> map){
		return sqlSessionFactory.openSession().update(nameSpace + "updateBoardHistoryModify", map);
	}
	
}
