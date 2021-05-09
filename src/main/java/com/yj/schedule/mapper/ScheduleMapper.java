package com.yj.schedule.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yj.schedule.vo.ScheduleVO;




@Mapper
public interface ScheduleMapper {
	
	List<ScheduleVO> selectScheduleList(); 
	
	ScheduleVO selectSchedule(String chId);
	
	
	int updateSchedule(Map<String, Object> mapParams);
	
}
