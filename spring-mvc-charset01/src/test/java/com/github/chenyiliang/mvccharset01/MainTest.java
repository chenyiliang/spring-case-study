package com.github.chenyiliang.mvccharset01;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring-rest.xml" })
public class MainTest {
	@Autowired
	private RestTemplate restTemplate;

	// 目前看只有使用最新Spring4的RestTemplate才能保证multipart上传文件和文本域字符不会乱码
	@Test
	public void testUpload1() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		FileSystemResource resource = new FileSystemResource(new File("D:/data/阿里数加.txt"));
		System.out.println(headers);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("name", "陈熠樑");
		body.add("file", resource);
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);
		System.out.println(entity);
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/main/upload1", entity, String.class);
		System.out.println(response);
	}
}
