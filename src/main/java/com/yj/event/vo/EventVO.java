package com.yj.event.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class EventVO {
	private String startTime;
	private String endTime;
	private String chId;
	private Long detectId;
	private Long objectId;
	private String detectName;
	private String objName;
	private String fileLoc;
	private String fileName;
}
