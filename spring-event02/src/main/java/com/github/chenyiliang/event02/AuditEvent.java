package com.github.chenyiliang.event02;

import org.springframework.context.ApplicationEvent;

public class AuditEvent extends ApplicationEvent {
	private static final long serialVersionUID = -5129530528538759836L;
	private Boolean status;// 当前申报状态
	private String work;// 申报作品
	private String advice;// 当前申报意见

	public AuditEvent(Object source) {
		super(source);
		this.status = true;
		this.advice = "尚未审核";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@Override
	public String toString() {
		return "AuditEvent [status=" + status + ", work=" + work + ", advice=" + advice + "]";
	}

}
