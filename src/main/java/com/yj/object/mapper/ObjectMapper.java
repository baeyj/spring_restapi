package com.yj.object.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yj.object.vo.ObjectVO;




@Mapper
public interface ObjectMapper {
	
	List<ObjectVO> selectObjectList(String chId); 
	
	int updateObject(Map<String, Object> mapParams);
	
	List<ObjectVO> selectObjectInfoList(); 
	
}
