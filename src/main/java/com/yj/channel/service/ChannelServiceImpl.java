package com.yj.channel.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.channel.mapper.ChannelMapper;
import com.yj.channel.vo.ChannelVO;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelMapper channelMapper;
	
	@Override
	public List<ChannelVO> selectChannelList() throws SQLException {
		
		return channelMapper.selectChannelList();
	}

	@Override
	public int insertChannel(ChannelVO channelVO) throws SQLException {
		
		return channelMapper.insertChannel(channelVO);
	}

	@Override
	public int updateChannel(ChannelVO channelVO) throws SQLException {
		
		return channelMapper.updateChannel(channelVO);
	}

	@Override
	public int deleteChannel(String chId) throws SQLException {
		
		return channelMapper.deleteChannel(chId);
	}

	@Override
	public ChannelVO selectChannel(String chId) throws SQLException {

		return channelMapper.selectChannel(chId);
	}

	

}
