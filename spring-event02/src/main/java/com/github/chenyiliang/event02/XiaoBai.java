package com.github.chenyiliang.event02;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class XiaoBai implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void reportWorks() {// 申报作品
		AuditEvent auditEvent = new AuditEvent(this);
		applicationContext.publishEvent(auditEvent);
		System.out.println("最终审核结果：" + auditEvent.getStatus() + "——" + auditEvent.getAdvice());// 小白获取期待已久的最终结果
	}

}
