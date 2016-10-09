package com.swapit.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.swapit.ws.controller.PropositionController;
import com.swapit.ws.model.PropositionModel;

@Path("/proposition")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PropositionService {
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		PropositionController propCtrl = new PropositionController();
		return Response.ok(propCtrl.getALL()).build();
	};
	
	@GET
	@Path("/getPropByDescription/{}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPropositionByDescription(@PathParam("Description") String description){
		return null;
	};
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(PropositionModel propositionModel){
		PropositionController propCtrl = new PropositionController();
		propCtrl.save(propositionModel);
		return null;
	};
	
	

}
