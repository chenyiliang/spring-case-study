package com.github.chenyiliang.async01.service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService2 {
	public Map<String, Object> syncCall() {
		System.out.println("sync start !");
		System.out.println("sync end !");
		return Collections.singletonMap("username", "teaboy");
	}

	@Async
	public void asyncCall() {
		System.out.println("async start !");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// ignore
		}
		System.out.println("async end !");
	}
}
