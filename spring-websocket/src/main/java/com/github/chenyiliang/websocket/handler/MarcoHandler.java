package com.github.chenyiliang.websocket.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component("marcoHandler")
public class MarcoHandler extends AbstractWebSocketHandler {
	private static final Logger LOG = LoggerFactory.getLogger(MarcoHandler.class);

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		LOG.info("Connection established");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		LOG.info("Received message: {}", message.getPayload());
		TimeUnit.SECONDS.sleep(2);
		session.sendMessage(new TextMessage("Polo!"));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOG.info("Connection closed. Status: {}", status);
	}
}
