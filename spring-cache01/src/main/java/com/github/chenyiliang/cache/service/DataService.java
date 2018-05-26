package com.github.chenyiliang.cache.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	private static final Logger LOG = LoggerFactory.getLogger(DataService.class);

	@Cacheable("data")
	public Map<String, Object> getDataById(String id) {
		if ("3".equals(id)) {
			return null;
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("id", id);
		dataMap.put("today", new Date());
		LOG.info("Get Data: {} For Id: {} !!!", dataMap, id);
		return dataMap;
	}
}
