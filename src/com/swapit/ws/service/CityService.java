package com.swapit.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.swapit.ws.controller.CityController;

@Path("/city")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CityService {
	
	@GET
	@Path("/getCityState/{stateID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCityState(@PathParam("stateID") String stateID){
		
		CityController cityCtrl = new CityController();
		return Response.ok(cityCtrl.getCityState(stateID)).build();
		
	}

}
