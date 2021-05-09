package com.yj.channelstatus.service;

import java.sql.SQLException;
import java.util.List;

import com.yj.channelstatus.vo.ChannelStatusVO;


public interface ChannelStatusService {
	public List<ChannelStatusVO> selectChannelStatusList() throws SQLException;
	
	public ChannelStatusVO selectChannelStatus(String chId) throws SQLException;
}
