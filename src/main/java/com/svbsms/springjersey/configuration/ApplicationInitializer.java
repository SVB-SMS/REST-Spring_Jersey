package com.svbsms.springjersey.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * This is used to bootstrap the spring application xml-less way
 * */

@Order(1)  //to make sure this initializer occurs before jersey
public class ApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		sc.setInitParameter("contextConfigLocation", "noop");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfiguration.class);
		sc.addListener(new ContextLoaderListener(context));
		sc.addListener(new RequestContextListener());
		
	}

}
