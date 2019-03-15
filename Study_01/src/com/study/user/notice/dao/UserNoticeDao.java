package com.study.user.notice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.common.dao.CommonDao;

@Repository
public class UserNoticeDao extends CommonDao {

	private String nameSpace = "userNoticeDao.";

	public List<Map<String, Object>> selectNoticeList( Map<String, Object> map ) {
		return getSqlSession().selectList( nameSpace + "selectNoticeList", map );
	}

}
