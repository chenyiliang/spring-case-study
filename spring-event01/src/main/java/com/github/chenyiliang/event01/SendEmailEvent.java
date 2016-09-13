package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationEvent;

public class SendEmailEvent extends ApplicationEvent {
	private static final long serialVersionUID = -7499903627908465133L;
	private String emailAddress;

	public SendEmailEvent(Object source, String emailAddress) {
		super(source);
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

}
