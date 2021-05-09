package com.yj.detection.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yj.detection.vo.DetectionVO;



public interface DetectionService {
	List<DetectionVO> selectDetectionList(String chId) throws SQLException;

	public int updateDetection(Map<String, Object> mapParams) throws SQLException;
	
	List<DetectionVO> selectDetectionInfoList() throws SQLException;
}
