package com.github.chenyiliang.event01;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

@Async
public class RegisterListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof SendEmailEvent) {
			System.out.println("正在向" + ((SendEmailEvent) event).getEmailAddress() + "发送邮件......");// 模拟发送邮件事件
			try {
				Thread.sleep(1 * 1000);// 模拟请求邮箱服务器、验证账号密码，发送邮件耗时。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("邮件发送成功！");
		} else if (event instanceof SendMessageEvent) {
			System.out.println("正在向" + ((SendMessageEvent) event).getPhoneNum() + "发送短信......");// 模拟发送邮短信事件
			try {
				Thread.sleep(1 * 1000);// 模拟发送短信过程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("短信发送成功！");
		}
	}

}
