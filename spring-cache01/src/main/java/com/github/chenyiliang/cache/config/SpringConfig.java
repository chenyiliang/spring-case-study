package com.github.chenyiliang.cache.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.cache.interceptor.CacheOperationSource;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.github.chenyiliang.cache.interceptor.MyCacheInterceptor;

@EnableCaching
@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
	@Autowired
	private CacheOperationSource cacheOperationSource;
	@Autowired
	private CacheManager cacheManager;

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("data")));
		return cacheManager;
	}

	@Bean
	public CacheInterceptor cacheInterceptor() {
		CacheInterceptor interceptor = new MyCacheInterceptor();
		interceptor.setCacheOperationSources(cacheOperationSource);
		interceptor.setCacheManager(cacheManager);
		return interceptor;
	}
}
