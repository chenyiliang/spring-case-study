package com.github.chenyiliang.jetty01.controller;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.chenyiliang.jetty01.service.RestService;

@Controller
@RequestMapping("/rest")
public class RestController {
	@Autowired(required=false)
	private RestService restService;

	@RequestMapping("/today")
	@ResponseBody
	public Map<String, Date> getToday() {
		return Collections.singletonMap("today", restService.getToday());
	}
}
