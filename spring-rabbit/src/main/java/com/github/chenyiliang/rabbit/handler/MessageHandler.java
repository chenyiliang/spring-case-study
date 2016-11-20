package com.github.chenyiliang.rabbit.handler;

import java.util.HashMap;

public class MessageHandler {
	public void handleMessage(HashMap<String, Object> message) {
		System.out.println("Message:" + message);
		System.out.println("Thread:" + Thread.currentThread());
	}
}
