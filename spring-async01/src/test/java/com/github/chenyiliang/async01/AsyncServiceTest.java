package com.github.chenyiliang.async01;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.chenyiliang.async01.service.AsyncService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring-async01.xml" })
public class AsyncServiceTest {
	@Autowired
	private AsyncService asyncService;

	@Test
	public void test() {
		asyncService.syncCall();
		System.out.println("test end !");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
	}

	@Test
	public void test2() {
		asyncService.syncCall2();
		System.out.println("test end !");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
	}
}
