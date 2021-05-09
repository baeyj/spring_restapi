package com.yj.channelstatus.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yj.channelstatus.service.ChannelStatusService;
import com.yj.channelstatus.vo.ChannelStatusVO;
import com.yj.exception.NotFoundException;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/channel")
public class ChannelStatusController {
	Logger logger = LoggerFactory.getLogger(ChannelStatusController.class);
	
	@Autowired
    private ChannelStatusService channelStatusService;
	
	
	
	@ApiOperation(value = "모든 채널 status 리스트")
	@GetMapping("/status")
	public ResponseEntity<List<ChannelStatusVO>> statusList() throws Exception{
		ResponseEntity<List<ChannelStatusVO>> entity = null;
		
        entity = new ResponseEntity<>(
        		channelStatusService.selectChannelStatusList(), HttpStatus.OK);
            
		return entity;
	}
	
	@ApiOperation(value = "단일 채널 status 조회")
	@GetMapping("/status/{chId}")
	public ResponseEntity<ChannelStatusVO> getStatusDetail(@PathVariable("chId") String chId) throws Exception{
		ResponseEntity<ChannelStatusVO> entity = null;
		
		ChannelStatusVO channelStatusVO = channelStatusService.selectChannelStatus(chId);
		if( channelStatusVO == null) {
			throw new NotFoundException(chId);
		}
		
        entity = new ResponseEntity<>(
        		channelStatusVO, HttpStatus.OK);
            
		return entity;
	}
	
}
