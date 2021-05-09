package com.yj.event.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.event.mapper.EventMapper;
import com.yj.event.vo.EventVO;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventMapper eventMapper;

	@Override
	public List<EventVO> selectEventList(Map<String, Object> mapParams) throws SQLException {
		
		return eventMapper.selectEventList(mapParams);
	}
	
	
}
