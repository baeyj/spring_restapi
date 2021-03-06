package com.yj.detection.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class DetectionVO {
	private Long detectId;
	private String detectName;
	private String chId;
	private String detectPos;
	private Boolean isUsed;
}
