package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-event.xml");
		UserService userService = ac.getBean(UserService.class);
		long beginTime = System.currentTimeMillis();
		userService.doLogin("chenyiliangconan@qq.com", "12345678");
		System.out.println("处理注册相关业务耗时" + (System.currentTimeMillis() - beginTime) + "ms");
		System.out.println("处理其他业务逻辑开始..");
		Thread.sleep(500);
		System.out.println("处理其他业务逻辑结束..");
		System.out.println("处理所有业务耗时" + (System.currentTimeMillis() - beginTime) + "ms");
		System.out.println("向客户端发送注册成功响应");
	}

}
