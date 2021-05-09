package com.yj.object.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yj.object.service.ObjectService;
import com.yj.object.vo.ObjectVO;

import io.swagger.annotations.ApiOperation;

@RestController
public class ObjectController {

	@Autowired
	private ObjectService objectService;
	
	@ApiOperation(value = "모든 채널 객체 정보 리스트")
	@GetMapping("/object")
	public ResponseEntity<List<ObjectVO>> infoList() throws Exception{
		ResponseEntity<List<ObjectVO>> entity = null;
		
        entity = new ResponseEntity<>(
        		objectService.selectObjectInfoList(), HttpStatus.OK);
            
		return entity;
	}
}
