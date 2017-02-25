package com.github.chenyiliang.tomcat01;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.Tomcat.FixContextListener;
import org.springframework.web.servlet.DispatcherServlet;

public class TomcatRawEmbed {
	private static final int PORT = 9090;

	public static void main(String[] args) throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(PORT);

		Connector connector = new Connector();
		connector.setPort(PORT);

		tomcat.getService().addConnector(connector);

		String contextPath = "";
		StandardContext context = new StandardContext();
		context.setPath(contextPath);
		context.addLifecycleListener(new FixContextListener());
		tomcat.getHost().addChild(context);

		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setContextConfigLocation("classpath:spring-context.xml");
		tomcat.addServlet(contextPath, "dispatcherServlet", dispatcherServlet);
		context.addServletMappingDecoded("/", "dispatcherServlet");
		tomcat.start();
		tomcat.getServer().await();

	}

}
