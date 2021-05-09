package com.yj.event.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yj.event.vo.EventVO;


public interface EventService {
	List<EventVO> selectEventList(Map<String, Object> mapParams) throws SQLException;

	

}
