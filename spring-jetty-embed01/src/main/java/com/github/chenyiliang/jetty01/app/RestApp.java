package com.github.chenyiliang.jetty01.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestApp {
	private static final AbstractApplicationContext JETTY_CONTEXT = new ClassPathXmlApplicationContext("spring-jetty.xml");

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			if (JETTY_CONTEXT != null) {
				JETTY_CONTEXT.close();
			}
		}));
	}

}
