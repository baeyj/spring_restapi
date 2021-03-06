package com.yj.channel.service;

import java.sql.SQLException;
import java.util.List;

import com.yj.channel.vo.ChannelVO;


public interface ChannelService {
	
	public List<ChannelVO> selectChannelList() throws SQLException;
	
	public int insertChannel(ChannelVO channelVO) throws SQLException; 
	
	public int updateChannel(ChannelVO channelVO) throws SQLException;
	
	public int deleteChannel(String chId) throws SQLException;
	
	public ChannelVO selectChannel(String chId) throws SQLException;
	
	

}
