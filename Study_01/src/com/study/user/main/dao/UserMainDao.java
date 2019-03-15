package com.study.user.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.common.dao.CommonDao;

@Repository
public class UserMainDao extends CommonDao {

	private String nameSpace = "userMainDao.";

	public List<Map<String, Object>> selectList( Map<String, Object> map ) {
		return getSqlSession().selectList( nameSpace + "selectList", map );
	}

}
