package com.nttdata;


import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("date/{dateString}")
public class MyDateResource {

//  @GET
//  @Produces(MediaType.TEXT_PLAIN)
//    public String getDate(@PathParam("dateString") MyDate dateString){
//	      return dateString.toString();
//   }


	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	    public Date getDate(@PathParam("dateString") String dateString){
	    	Calendar calendar= Calendar.getInstance();
  
		  if(dateString.equalsIgnoreCase("tomorrrow"))
		    {
		    	calendar.add(Calendar.DATE, 1);
		    }
		  if(dateString.equalsIgnoreCase("yesterday"))
		    {
		    	calendar.add(Calendar.DATE, -1);
		    }
		  return calendar.getTime();
	   }
}
