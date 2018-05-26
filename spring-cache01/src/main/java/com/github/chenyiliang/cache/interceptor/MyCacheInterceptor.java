package com.github.chenyiliang.cache.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.interceptor.CacheInterceptor;

public class MyCacheInterceptor extends CacheInterceptor {
	private static final long serialVersionUID = -539765407847638448L;

	private static final Logger LOG = LoggerFactory.getLogger(MyCacheInterceptor.class);

	@Override
	protected ValueWrapper doGet(Cache cache, Object key) {
		ValueWrapper valueWrapper = super.doGet(cache, key);
		if (valueWrapper != null) {
			LOG.info("Get Data: {} From Cache[{}] For Id: {} !!!", valueWrapper.get(), cache.getName(), key);
		}
		return valueWrapper;
	}

}
