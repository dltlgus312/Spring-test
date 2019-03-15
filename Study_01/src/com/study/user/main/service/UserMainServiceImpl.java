package com.study.user.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.user.main.dao.UserMainDao;


@Repository
public class UserMainServiceImpl implements UserMainService{

	@Autowired
	private UserMainDao userMainDao;
	
	@Override
	public List<Map<String, Object>> selectList( Map<String, Object> map ) {
		return userMainDao.selectList( map );
	}

}

