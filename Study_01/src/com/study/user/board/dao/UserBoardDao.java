package com.study.user.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.common.dao.CommonDao;

@Repository
public class UserBoardDao extends CommonDao{
	
	private String nameSpace = "userBoardDao.";

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("search", map.get("search"));
		pMap.put("page", ((int) map.get("page")-1) * (int) map.get("bundle"));
		pMap.put("bundle", map.get("bundle"));
		
		return getSqlSession().selectList(nameSpace + "selectBoardList", pMap);
	}
	
	public int selectBoardCount(Map<String, Object> map){
		return getSqlSession().selectOne(nameSpace + "selectBoardCount", map);
	}
	
	public Map<String, Object> selectBoardContents(int number){
		return getSqlSession().selectOne(nameSpace + "selectBoardContents", number);
	}
	
	public List<Map<String, Object>> searchBoard(String keyword){
		return getSqlSession().selectList(nameSpace + "selectBoardSearch", keyword);
	}
	
	public int insertBoard(Map<String, Object> map){
		return getSqlSession().insert(nameSpace+"insertBoardGener", map);
	}
	
	public int updateBoard(Map<String, Object> map){
		return getSqlSession().update(nameSpace + "updateBoardModify", map);
	}
	
	public int deleteBoard(int number){
		return getSqlSession().update(nameSpace + "deleteBoard", number);
	}
	
	public int selectLastSn(){
		return getSqlSession().selectOne(nameSpace + "selectLastSn");
	}

}
