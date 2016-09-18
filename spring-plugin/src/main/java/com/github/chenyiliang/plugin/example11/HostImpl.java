package com.github.chenyiliang.plugin.example11;

import java.util.List;

import org.springframework.util.Assert;

public class HostImpl implements Host {

	private final List<MyPluginInterface> plugins;

	public HostImpl(List<MyPluginInterface> plugins) {
		Assert.notNull(plugins);
		this.plugins = plugins;
	}

	@Override
	public void someBusinessMethod() {
		plugins.forEach(MyPluginInterface::bar);
	}

}
