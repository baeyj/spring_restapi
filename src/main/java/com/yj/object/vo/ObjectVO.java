package com.yj.object.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class ObjectVO {
	private Long objId;
	private String objName;
	private String chId;
	private Long responsiveness;
	private Boolean isUsed;
}
