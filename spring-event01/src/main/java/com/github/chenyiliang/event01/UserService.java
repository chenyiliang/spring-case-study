package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class UserService implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void doLogin(String emailAddress, String phoneNum) throws InterruptedException {
		Thread.sleep(200);// 模拟用户注册的相关业务逻辑处理
		System.out.println("注册成功！");
		// 下列向用户发送邮件
		SendEmailEvent sendEmailEvent = new SendEmailEvent(this, emailAddress);
		SendMessageEvent sendMessageEvent = new SendMessageEvent(this, phoneNum);
		applicationEventPublisher.publishEvent(sendEmailEvent);
		applicationEventPublisher.publishEvent(sendMessageEvent);
	}
}
