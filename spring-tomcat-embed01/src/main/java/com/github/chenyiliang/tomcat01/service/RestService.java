package com.github.chenyiliang.tomcat01.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class RestService {
	public Date getToday() {
		return new Date();
	}
}
