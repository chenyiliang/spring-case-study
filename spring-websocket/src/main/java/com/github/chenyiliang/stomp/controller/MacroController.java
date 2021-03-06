package com.github.chenyiliang.stomp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.github.chenyiliang.stomp.model.Shout;

@Controller
public class MacroController {
	private static final Logger LOG = LoggerFactory.getLogger(MacroController.class);

	@MessageMapping("/marco")
	@SendTo("/topic/shout")
	public Shout handleShout(Shout incoming) {
		LOG.info("Received message:{} !", incoming.getMessage());
		Shout outgoing = new Shout();
		outgoing.setMessage("Polo!");
		return outgoing;
	}
}
