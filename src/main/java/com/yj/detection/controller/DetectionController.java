package com.yj.detection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yj.detection.service.DetectionService;
import com.yj.detection.vo.DetectionVO;

import io.swagger.annotations.ApiOperation;

@RestController
public class DetectionController {
	
	@Autowired
	private DetectionService detectionService;
	
	@ApiOperation(value = "모든 탐지 정보 리스트")
	@GetMapping("/detection")
	public ResponseEntity<List<DetectionVO>> infoList() throws Exception{
		ResponseEntity<List<DetectionVO>> entity = null;
		
        entity = new ResponseEntity<>(
        		detectionService.selectDetectionInfoList(), HttpStatus.OK);
            
		return entity;
	}

}
