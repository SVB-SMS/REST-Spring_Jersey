package com.svbsms.springjersey.configuration;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.web.filter.RequestContextFilter;

@ApplicationPath("/resources")
public class JerseyAppConfig extends ResourceConfig{

	public JerseyAppConfig(){
		packages("com.svbsms.springjersey.rest"); // tell jersey to scan the package for resources @Path etc.
		register(RequestContextFilter.class); //acts as a bridge b/w spring and jersey requests attributes
		property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true); //set it so that instead of server sending error messages it will send error code
	}
}
