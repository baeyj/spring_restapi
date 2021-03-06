package com.yj.channel.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class ChannelVO {
	private String chId;
	private String cctvModel;
	private String cctvLoc;
	private String cctvIp;
	private Long cctvPort;
	private String cctvRtsp;
	private String serverIp;
	private Long serverPort;
	private String serverRtsp;
	private String registDate;
	private String registUser;
	private String modifyDate;
	private String modifyUser;
	private Boolean isUsed;
}
