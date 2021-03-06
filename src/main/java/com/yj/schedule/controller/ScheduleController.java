package com.yj.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yj.exception.NotFoundException;
import com.yj.schedule.service.ScheduleService;
import com.yj.schedule.vo.ScheduleVO;

import io.swagger.annotations.ApiOperation;

@RestController
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	
	@ApiOperation(value = "모든 채널 스케쥴링 정보 리스트")
	@GetMapping("/channel/schedule")
	public ResponseEntity<List<ScheduleVO>> scheduleList() throws Exception{
		ResponseEntity<List<ScheduleVO>> entity = null;
		
        entity = new ResponseEntity<>(
        		scheduleService.selectScheduleList(), HttpStatus.OK);
            
		return entity;
	}
	
	@ApiOperation(value = "해당 채널 스케쥴링 정보")
	@GetMapping("/channel/schedule/{chId}")
	public ResponseEntity<ScheduleVO> getScheduleDetail(@PathVariable("chId") String chId) throws Exception{
		ResponseEntity<ScheduleVO> entity = null;
		
		ScheduleVO scheduleVO = scheduleService.selectSchedule(chId);
		if( scheduleVO == null) {
			throw new NotFoundException(chId);
		}
		
        entity = new ResponseEntity<>(
        		scheduleVO, HttpStatus.OK);
            
		return entity;
	}

}
