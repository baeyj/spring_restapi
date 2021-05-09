package com.yj.channelstatus.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.channelstatus.mapper.ChannelStatusMapper;
import com.yj.channelstatus.vo.ChannelStatusVO;

@Service
public class ChannelStatusServiceImpl implements ChannelStatusService {
	@Autowired
	private ChannelStatusMapper channelStatusMapper;
	
	@Override
	public List<ChannelStatusVO> selectChannelStatusList() throws SQLException {
		
		return channelStatusMapper.selectChannelStatusList();
	}

	@Override
	public ChannelStatusVO selectChannelStatus(String chId) throws SQLException {
		
		return channelStatusMapper.selectChannelStatus(chId);
	}
}
