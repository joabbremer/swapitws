package com.swapit.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.swapit.ws.controller.PropositionController;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.reduce.PropositionReduce;

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
	@Path("/getbyID/{id}")
	public Response getbyID(@PathParam("id") String id){
		PropositionController propCtrl = new PropositionController();
		return Response.ok(propCtrl.getbyID(id)).build();
		
	}
	@GET
	@Path("/getPropPerson/{personID}")
	public Response getPropPerson(@PathParam("personID") String id){
		PropositionController propCtrl = new PropositionController();
		return Response.ok(propCtrl.getPropPerson(id)).build();
	}
	
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(PropositionReduce propositionReduce){
		PropositionController propCtrl = new PropositionController();
		return Response.ok(propCtrl.save(propositionReduce)).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(PropositionModel propositionModel){
		PropositionController propCtrl = new PropositionController();
		return Response.ok(propCtrl.update(propositionModel)).build();
		
	}

}
