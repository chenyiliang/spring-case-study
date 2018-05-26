package com.github.chenyiliang.cache.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chenyiliang.cache.service.DataService;

@RestController
@RequestMapping("/data")
public class DataController {
	@Autowired
	private DataService dataService;
	@Autowired
	private CacheInterceptor cacheInterceptor;

	@RequestMapping("/{id}")
	public Map<String, Object> getDataById(@PathVariable String id) {
		return dataService.getDataById(id);
	}
}
