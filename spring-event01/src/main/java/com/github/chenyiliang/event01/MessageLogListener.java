package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

@Async
public class MessageLogListener implements ApplicationListener<SendMessageEvent> {

	@Override
	public void onApplicationEvent(SendMessageEvent event) {
		System.out.println("监听到短信事件：" + event);
	}

}
