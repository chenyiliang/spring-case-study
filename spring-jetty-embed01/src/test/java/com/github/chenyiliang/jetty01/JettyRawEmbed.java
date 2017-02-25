package com.github.chenyiliang.jetty01;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class JettyRawEmbed {
	public static void main(String[] args) throws Exception {
		QueuedThreadPool threadPool = new QueuedThreadPool(50, 10);
		ServletContextHandler servletContextHandler = new ServletContextHandler();
		servletContextHandler.setContextPath("/");
		Server server = new Server(threadPool);
		server.setHandler(servletContextHandler);
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(8088);
		server.setConnectors(new Connector[] { connector });

		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setContextConfigLocation("classpath:spring-context.xml");
		ServletHolder dispatcherServletHolder = new ServletHolder(dispatcherServlet);
		servletContextHandler.addServlet(dispatcherServletHolder, "/");

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		corsConfiguration.setAllowedMethods(Arrays.asList("*"));
		corsConfiguration.setAllowedOrigins(Arrays.asList("*"));

		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
		corsConfigurationSource.setCorsConfigurations(Collections.singletonMap("/**", corsConfiguration));
		CorsFilter corsFilter = new CorsFilter(corsConfigurationSource);
		servletContextHandler.addFilter(new FilterHolder(corsFilter), "/*", null);
		server.start();
	}
}
