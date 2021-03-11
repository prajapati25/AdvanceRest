package com.nttdata;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class HeaderLogging implements ContainerRequestFilter,ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Response");
		System.out.println(responseContext.getHeaders());
		System.out.println("========Response");
		System.out.println(requestContext.getHeaders());
	
		
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("request");
		System.out.println(requestContext.getHeaders());
	}

}
