package com.yj.detection.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.detection.mapper.DetectionMapper;
import com.yj.detection.vo.DetectionVO;


@Service
public class DetectionServiceImpl implements DetectionService {

	@Autowired
	private DetectionMapper detectionMapper;
	
	@Override
	public List<DetectionVO> selectDetectionList(String chId) throws SQLException {
		
		return detectionMapper.selectDetectionList(chId);
	}

	@Override
	public int updateDetection(Map<String, Object> mapParams) throws SQLException {
		
		return detectionMapper.updateDetection(mapParams);
	}

	@Override
	public List<DetectionVO> selectDetectionInfoList() throws SQLException {
		
		return detectionMapper.selectDetectionInfoList();
	}
	

}
