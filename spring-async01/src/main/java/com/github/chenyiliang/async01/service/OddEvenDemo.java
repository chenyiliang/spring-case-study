package com.github.chenyiliang.async01.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OddEvenDemo {

	public static void main(String[] args) {
		BlockingQueue<Object> aToBQueue = new LinkedBlockingQueue<Object>();
		BlockingQueue<Object> bToAQueue = new LinkedBlockingQueue<Object>();
		Runnable runA = () -> {
			for (int i = 1; i <= 100; i = i + 2) {
				try {
					bToAQueue.take();
					System.out.println(i);
					aToBQueue.offer(new Object());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable runB = () -> {
			for (int i = 2; i <= 100; i = i + 2) {
				try {
					aToBQueue.take();
					System.out.println(i);
					bToAQueue.offer(new Object());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runA).start();
		new Thread(runB).start();
		bToAQueue.offer(new Object());
	}

}
