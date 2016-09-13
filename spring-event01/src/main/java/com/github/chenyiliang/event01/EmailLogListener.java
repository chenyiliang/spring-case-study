package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

@Async
public class EmailLogListener implements ApplicationListener<SendEmailEvent> {

	@Override
	public void onApplicationEvent(SendEmailEvent event) {
		System.out.println("监听到邮件事件：" + event);
	}

}
