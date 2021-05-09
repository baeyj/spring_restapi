package com.yj.detection.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yj.detection.vo.DetectionVO;




@Mapper
public interface DetectionMapper {
	
	List<DetectionVO> selectDetectionList(String chId); 
	
	int updateDetection(Map<String, Object> mapParams);
	
	List<DetectionVO> selectDetectionInfoList(); 
	/*
	int insertDetection(DetectionVO detectionVO); 
	
	
	
	int deleteDetection(String chId, String detectId);
	
	DetectionVO selectDetection(String chId, String detectId);
	*/
}
