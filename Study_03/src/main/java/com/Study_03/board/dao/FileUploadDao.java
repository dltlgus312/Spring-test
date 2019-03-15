package com.Study_03.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileUploadDao{
	
	private String nameSpace = "fileUpload.";
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public int insertFile(Map<String, Object> map){
		return sqlSessionFactory.openSession().insert(nameSpace + "insertFile", map);
	}
	public int updateFile(Map<String, Object> map){
		return sqlSessionFactory.openSession().update(nameSpace + "updateFile", map);
	}
	public Map<String, Object> selectFile(Map<String, Object> map){
		return sqlSessionFactory.openSession().selectOne(nameSpace + "selectFile", map);
	}
	public List<Map<String, Object>> selectListFile(Map<String, Object> map){
		return sqlSessionFactory.openSession().selectList(nameSpace + "selectListFile", map);
	}
	
	public void deleteFile(Map<String, Object> map){
		sqlSessionFactory.openSession().delete(nameSpace + "deleteFile", map);
	}

}
