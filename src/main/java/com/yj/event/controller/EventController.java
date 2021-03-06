package com.yj.event.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yj.event.service.EventService;
import com.yj.event.vo.EventVO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/event")
public class EventController {
	Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	@ApiOperation(value = "기간 내 모든 이벤트 정보")
	@GetMapping("/{start}/{end}")
	public ResponseEntity<List<EventVO>> eventList(@PathVariable("start") String start, @PathVariable("end") String end) throws Exception{
		logger.info("date : " + start + "~" + end);
		
		Map<String, Object> mapParams = new HashMap<String, Object>();
		mapParams.put("start", start);
		mapParams.put("end", end);
		
		ResponseEntity<List<EventVO>> entity = null;
	
		entity = new ResponseEntity<>(
				eventService.selectEventList(mapParams), HttpStatus.OK);
		 
		return entity;
	}
	
	@ApiOperation(value = "기간 내 해당 채널 이벤트 정보")
	@GetMapping("/{start}/{end}/channel/{channels}")
	public ResponseEntity<List<EventVO>> eventListByChId(@PathVariable("start") String start, @PathVariable("end") String end, @PathVariable("channels") String channels) throws Exception{
		logger.info("channels : " + channels);
		
		Map<String, Object> mapParams = new HashMap<String, Object>();
		mapParams.put("start", start);
		mapParams.put("end", end);
		
		String [] items = channels.split(",");
		List<String> list = Arrays.asList(items);
		mapParams.put("channels", list);
		
		ResponseEntity<List<EventVO>> entity = null;
	
		entity = new ResponseEntity<>(
				eventService.selectEventList(mapParams), HttpStatus.OK);
		 
		return entity;
	}
	
	@ApiOperation(value = "기간 내 해당 탐지 이벤트 정보")
	@GetMapping("/{start}/{end}/detection/{detections}")
	public ResponseEntity<List<EventVO>> eventListByDetection(@PathVariable("start") String start, @PathVariable("end") String end, @PathVariable("detections") String detections) throws Exception{
		
		
		Map<String, Object> mapParams = new HashMap<String, Object>();
		mapParams.put("start", start);
		mapParams.put("end", end);
		
		int[] items = Arrays.asList(detections.split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
		
		List<Integer> list = Arrays.stream(items).boxed().collect(Collectors.toList());
		logger.info("detections : " + list);
		mapParams.put("detections", list);
		
		ResponseEntity<List<EventVO>> entity = null;
	
		entity = new ResponseEntity<>(
				eventService.selectEventList(mapParams), HttpStatus.OK);
		 
		return entity;
	}
	
	@ApiOperation(value = "기간 내 객체 탐지 이벤트 정보")
	@GetMapping("/{start}/{end}/object/{objects}")
	public ResponseEntity<List<EventVO>> eventListByobject(@PathVariable("start") String start, @PathVariable("end") String end, @PathVariable("objects") String objects) throws Exception{
		logger.info("detections : " + objects);
		
		Map<String, Object> mapParams = new HashMap<String, Object>();
		mapParams.put("start", start);
		mapParams.put("end", end);
		
		int[] items = Arrays.asList(objects.split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
		
		List<Integer> list = Arrays.stream(items).boxed().collect(Collectors.toList());
		logger.info("objects : " + list);
		mapParams.put("objects", list);
		
		ResponseEntity<List<EventVO>> entity = null;
	
		entity = new ResponseEntity<>(
				eventService.selectEventList(mapParams), HttpStatus.OK);
		 
		return entity;
	}

}
