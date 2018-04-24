package com.svbsms.springjersey.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException>{

	public Response toResponse(CustomException arg0) {
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
