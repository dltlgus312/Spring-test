package com.study.user.notice.service;

import java.util.List;
import java.util.Map;

public interface UserNoticeService{
	
	public List<Map<String, Object>> selectNoticeList( Map<String, Object> map );
	
}
