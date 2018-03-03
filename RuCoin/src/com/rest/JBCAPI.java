package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.models.Response;

@Path("/api")
public class JBCAPI {
	
	@POST
	@Path("/text")
	@Produces("application/json")
	@Consumes("application/json")
	public Response sendJRelayTest(@QueryParam("client-id") int clientId){
		
		
		Response response = new Response();
		
		return response;
	}
}
