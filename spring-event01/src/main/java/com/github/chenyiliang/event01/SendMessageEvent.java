package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationEvent;

public class SendMessageEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1811746081322884679L;
	private String phoneNum;

	public SendMessageEvent(Object source, String phoneNum) {
		super(source);
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

}
