package com.github.chenyiliang.rabbit.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring-rabbit.xml");
	}

}
