package com.github.chenyiliang.mvccharset01.controller;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping("/form1")
	public String form1() {
		return "form1";
	}

	@ResponseBody
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public Map<String, Object> upload1(@RequestParam MultipartFile file, @RequestParam Map<String, Object> params) throws UnsupportedEncodingException {
		System.out.println("File Content-Type:" + file.getContentType());
		System.out.println("File Origin Name:" + file.getOriginalFilename());
		System.out.println("File Name:" + file.getName());
		System.out.println("---------------RequestParam---------------------------");
		Set<Entry<String, Object>> entrySet = params.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println("---------------RequestParam---------------------------");
		return Collections.singletonMap("status", "成功");
	}
}
