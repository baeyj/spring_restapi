package com.yj.object.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yj.object.vo.ObjectVO;

public interface ObjectService {
	public List<ObjectVO> selectObjectList(String chId) throws SQLException;
	
	public int updateObject(Map<String, Object> mapParams) throws SQLException;
	
	public List<ObjectVO> selectObjectInfoList() throws SQLException;

}
