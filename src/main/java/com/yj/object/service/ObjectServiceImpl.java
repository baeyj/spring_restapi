package com.yj.object.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.object.mapper.ObjectMapper;
import com.yj.object.vo.ObjectVO;

@Service
public class ObjectServiceImpl implements ObjectService {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public List<ObjectVO> selectObjectList(String chId) throws SQLException {
		
		return objectMapper.selectObjectList(chId);
	}

	@Override
	public int updateObject(Map<String, Object> mapParams) throws SQLException {
		
		return objectMapper.updateObject(mapParams);
	}

	@Override
	public List<ObjectVO> selectObjectInfoList() throws SQLException {
		
		return objectMapper.selectObjectInfoList();
	}

}
