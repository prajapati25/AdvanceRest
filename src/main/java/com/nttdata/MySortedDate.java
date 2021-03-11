package com.nttdata;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("sortedDate")
public class MySortedDate {

	@GET
	@Produces(value={"text/shortedDate",MediaType.TEXT_PLAIN})
	public Date getSortedDate()
	{
		Calendar calendar= Calendar.getInstance();
		return calendar.getTime();
	}
	
}
