package com.github.chenyiliang.rabbit;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring-rabbit-test.xml" })
public class RabbitMQTest {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hello", "world");
		for (int i = 0; i < 100; i++) {
			rabbitTemplate.convertAndSend(map);
		}

	}
}
