package com.yj.channelstatus.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class ChannelStatusVO {
	private String chId;
	private String svrTime;
	private String detectSet;
	private String objSet;
	private int cctvStatus;
}
