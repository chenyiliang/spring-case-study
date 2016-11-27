package com.github.chenyiliang.stomp.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.chenyiliang.stomp.model.Shout;

@Component
public class RandomNumberMessageSender {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Scheduled(fixedRate = 10000)
	public void sendRandomNumber() {
		Shout shout = new Shout();
		shout.setMessage("Random # : " + (Math.random() * 100));
		simpMessagingTemplate.convertAndSend("/topic/shout", shout);
	}
}
