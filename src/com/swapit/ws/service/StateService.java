package com.swapit.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.swapit.ws.controller.StateController;

@Path("/state")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StateService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getState(){
		StateController stateCtrl = new StateController();		
		return Response.ok(stateCtrl.getAll()).build();
		
	}

}
