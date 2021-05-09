package com.yj.schedule.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yj.schedule.vo.ScheduleVO;


public interface ScheduleService {
	public List<ScheduleVO> selectScheduleList() throws SQLException;
	
	public ScheduleVO selectSchedule(String chId) throws SQLException;
	
	
	public int updateSchedule(Map<String, Object> mapParams) throws SQLException;
}
