package com.nttdata;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class Authorization {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSecureAPI() {
		return "great";
	}

}
