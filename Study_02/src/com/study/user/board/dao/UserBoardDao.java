package com.study.user.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserBoardDao{
	
	private String nameSpace = "userBoardDao.";
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("search", map.get("search"));
		pMap.put("page", ((int) map.get("page")-1) * (int) map.get("bundle"));
		pMap.put("bundle", map.get("bundle"));
		
		return sqlSessionFactory.openSession().selectList(nameSpace + "selectBoardList", pMap);
	}
	
	public int selectBoardCount(Map<String, Object> map){
		return sqlSessionFactory.openSession().selectOne(nameSpace + "selectBoardCount", map);
	}
	
	public Map<String, Object> selectBoardContents(int number){
		return sqlSessionFactory.openSession().selectOne(nameSpace + "selectBoardContents", number);
	}
	
	public List<Map<String, Object>> searchBoard(String keyword){
		return sqlSessionFactory.openSession().selectList(nameSpace + "selectBoardSearch", keyword);
	}
	
	public int insertBoard(Map<String, Object> map){
		return sqlSessionFactory.openSession().insert(nameSpace+"insertBoardGener", map);
	}
	
	public int updateBoard(Map<String, Object> map){
		return sqlSessionFactory.openSession().update(nameSpace + "updateBoardModify", map);
	}
	
	public int deleteBoard(int number){
		return sqlSessionFactory.openSession().update(nameSpace + "deleteBoard", number);
	}
	
	public int selectLastSn(){
		return sqlSessionFactory.openSession().selectOne(nameSpace + "selectLastSn");
	}

}
