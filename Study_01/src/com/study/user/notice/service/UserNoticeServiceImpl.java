package com.study.user.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.user.notice.dao.UserNoticeDao;


@Repository
public class UserNoticeServiceImpl implements UserNoticeService{

	@Autowired
	private UserNoticeDao userNoticeDao;
	
	@Override
	public List<Map<String, Object>> selectNoticeList( Map<String, Object> map ) {
		return userNoticeDao.selectNoticeList( map );
	}

}

