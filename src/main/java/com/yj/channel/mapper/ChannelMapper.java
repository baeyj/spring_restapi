package com.yj.channel.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yj.channel.vo.ChannelVO;





@Mapper
public interface ChannelMapper {
	
	List<ChannelVO> selectChannelList(); 

	int insertChannel(ChannelVO channelVO); 
	
	int updateChannel(ChannelVO channelVO);
	
	int deleteChannel(String chId);
	
	ChannelVO selectChannel(String chId);
}
