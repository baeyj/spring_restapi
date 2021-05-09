package com.yj.channelstatus.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yj.channelstatus.vo.ChannelStatusVO;




@Mapper
public interface ChannelStatusMapper {
		
	List<ChannelStatusVO> selectChannelStatusList(); 
	
	ChannelStatusVO selectChannelStatus(String chId);
}
