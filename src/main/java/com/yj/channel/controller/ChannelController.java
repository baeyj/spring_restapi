package com.yj.channel.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yj.channel.service.ChannelService;
import com.yj.channel.vo.ChannelVO;
import com.yj.detection.service.DetectionService;
import com.yj.detection.vo.DetectionVO;
import com.yj.exception.NotFoundException;
import com.yj.object.service.ObjectService;
import com.yj.object.vo.ObjectVO;
import com.yj.schedule.service.ScheduleService;
import com.yj.schedule.vo.ScheduleVO;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/channel")
public class ChannelController {
	Logger logger = LoggerFactory.getLogger(ChannelController.class);
	
	@Autowired
    private ChannelService channelService;
	
	@Autowired
	private ObjectService objectService;
	
	@Autowired
	private DetectionService detectionService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@ApiOperation(value = "채널 정보 리스트")
	@GetMapping("/info")
	public ResponseEntity<List<ChannelVO>> infoList() throws Exception{
		ResponseEntity<List<ChannelVO>> entity = null;
		
        entity = new ResponseEntity<>(
        channelService.selectChannelList(), HttpStatus.OK);
            
		return entity;
	}

	@ApiOperation(value = "단일 채널 정보 조회")
	@GetMapping("/info/{chId}")
	public ResponseEntity<ChannelVO> getInfo(@PathVariable("chId") String chId) throws Exception{
		ResponseEntity<ChannelVO> entity = null;

		ChannelVO channelVO = channelService.selectChannel(chId);
		
		if(channelVO == null) {
			throw new NotFoundException(chId);
		}
		entity = new ResponseEntity<>(channelVO, HttpStatus.OK);
			
		return entity;
	}
	
	@ApiOperation(value = "채널 정보 등록")
	@PostMapping("/info")
	public ResponseEntity<String> insert(@RequestBody ChannelVO channelVO) throws Exception{
		ResponseEntity<String> entity = null;
    
    	channelService.insertChannel(channelVO);
        entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
  
        return entity;
	}
	
	@ApiOperation(value = "채널 정보 수정")
	@PutMapping("/info/{chId}")
	public ResponseEntity<String> update(@PathVariable("chId") String chId, @RequestBody ChannelVO channelVO) throws Exception{
		ResponseEntity<String> entity = null;
        
    	channelVO.setChId(chId);
    	int check = channelService.updateChannel(channelVO);
    	
    	if(check<1) {
    		throw new NotFoundException(chId);
    	}
        entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        
        return entity;
	}

	@ApiOperation(value = "채널 정보 삭제")
	@DeleteMapping("/info/{chId}")
	public ResponseEntity<String> delete(@PathVariable("chId") String chId) throws Exception{
		ResponseEntity<String> entity = null;
        
		int check = channelService.deleteChannel(chId);
		
		if(check<1) {
    		throw new NotFoundException(chId);
    	}	
        entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        
        return entity;
	}
	
	@ApiOperation(value = "단일 채널 상세 조회")
	@GetMapping("/info/detail/{chId}")
	public ResponseEntity<HashMap<String, Object>> getInfoDetail(@PathVariable("chId") String chId) throws Exception{
		ResponseEntity<HashMap<String, Object>> entity = null;
		HashMap<String, Object> resultMap = new HashMap<>();
		
		ChannelVO channelVO = channelService.selectChannel(chId);
	
		if( channelVO == null) {
			throw new NotFoundException(chId);
		}
		resultMap.put("channelInfo", channelVO);
		
		List<ObjectVO> objectList = objectService.selectObjectList(chId);
		resultMap.put("objectList", objectList);
		
		List<DetectionVO> detectionList = detectionService.selectDetectionList(chId);
		resultMap.put("detectionList", detectionList);
		
		ScheduleVO scheduleVO = scheduleService.selectSchedule(chId);
		if( scheduleVO == null) {
			throw new NotFoundException(chId);
		}
		resultMap.put("schedule", scheduleVO);
		
		entity = new ResponseEntity<HashMap<String, Object>>(resultMap, HttpStatus.OK);
			
		return entity;
	}
	
	
	@ApiOperation(value = "단일 채널 상세 수정")
	@PutMapping("/info/detail/{chId}")
	public ResponseEntity<String> updateInfoDetail(@PathVariable("chId") String chId, @RequestBody HashMap<String, Object> params) throws Exception{
		logger.info("params : "+params);
		
		//Object channelVO = params.get("channelInfo");
		
		List<ObjectVO> objectList = (List<ObjectVO>) params.get("objectList");

		if (CollectionUtils.isEmpty(objectList) == false) {
			HashMap<String, Object> mapParams = new HashMap<String, Object>();
			mapParams.put("objectList", objectList);
			mapParams.put("chId", chId);

			objectService.updateObject(mapParams);
		}
		
		List<DetectionVO> detectionList = (List<DetectionVO>) params.get("detectionList");
		if (CollectionUtils.isEmpty(detectionList) == false) {
			Map<String, Object> mapParams = new HashMap<String, Object>();
			mapParams.put("detectionList", detectionList);
			mapParams.put("chId", chId);

			detectionService.updateDetection(mapParams);
		}
		
		Object objectVO = params.get("schedule");
		logger.info("objectVO : "+objectVO);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(objectVO);
		ScheduleVO scheduleVO = gson.fromJson(jsonString, ScheduleVO.class);
		logger.info("jsonString : "+jsonString);
		logger.info("scheduleVO : "+scheduleVO);
		
		HashMap<String, Object> mapParams = new HashMap<String, Object>();
		mapParams.put("scheduleVO", scheduleVO);
		mapParams.put("chId", chId);
		
		int check = scheduleService.updateSchedule(mapParams);
    	if(check<1) {
    		throw new NotFoundException(chId);
    	}

		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		 
		return entity;
	}
	
	
}
