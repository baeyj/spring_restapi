package com.yj.event.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yj.event.vo.EventVO;




@Mapper
public interface EventMapper {
	
	List<EventVO> selectEventList(Map<String, Object> mapParams); 
	
	
}
