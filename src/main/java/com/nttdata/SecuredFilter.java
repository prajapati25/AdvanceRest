package com.nttdata;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecuredFilter implements ContainerRequestFilter {
	public static final String AUTHORISATION_HEADER_KEY = "Authorization";
	public static final String AUTHORISATION_HEADER_PREFIX = "Basic ";
	public static final String SECURED_URI_PREFIX = "secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		if (requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORISATION_HEADER_KEY);
			
			if (authHeader != null && authHeader.size()>0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORISATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer stringTokenizer = new StringTokenizer(decodedString, ":");
				String userName = stringTokenizer.nextToken();
				String password = stringTokenizer.nextToken();
				if (userName.equalsIgnoreCase("Himasnhu") && password.equals("prajapati")) {
					return;
				}		
			
			}
				Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
						.entity("You can not acccess the resource").build();
				requestContext.abortWith(unauthorizedStatus);
			
		}

	}
}
