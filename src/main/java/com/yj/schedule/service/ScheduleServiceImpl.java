package com.yj.schedule.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.schedule.mapper.ScheduleMapper;
import com.yj.schedule.vo.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Override
	public List<ScheduleVO> selectScheduleList() throws SQLException {
		
		return scheduleMapper.selectScheduleList();
	}

	@Override
	public ScheduleVO selectSchedule(String chId) throws SQLException {
		
		return scheduleMapper.selectSchedule(chId);
	}
	/*
	@Override
	public int updateSchedule(ScheduleVO scheduleVO) throws SQLException {
		
		return scheduleMapper.updateSchedule(scheduleVO);
	}
	*/

	@Override
	public int updateSchedule(Map<String, Object> mapParams) throws SQLException {
		
		return  scheduleMapper.updateSchedule(mapParams);
	}
}
