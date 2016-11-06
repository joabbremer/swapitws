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
import javax.ws.rs.core.Response.Status;

import com.swapit.ws.controller.PropositionController;
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
		if(propCtrl.getbyID(id) != null){
			return Response.ok(propCtrl.getbyID(id)).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
		
	}
	@GET
	@Path("/getPropCategory/{categoryID}")
	public Response getPropCategory(@PathParam("categoryID") String categoryID){
		PropositionController propCtrl = new PropositionController();
		if(propCtrl.getPropCategory(categoryID) != null){
			return Response.ok(propCtrl.getPropCategory(categoryID)).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}
	
	@GET
	@Path("/getPropLike/{title}/{category}/{city}/{price_max}/{price_min}")
	public Response getPropLike(@PathParam("title") String title,
							@PathParam("category") String category,
							@PathParam("city") String city,
							@PathParam("price_max") Double price_max,
							@PathParam("price_min") Double price_min){
		PropositionController propCtrl = new PropositionController();
		String propLike = propCtrl.getPropLike(title, category, city, price_max, price_min);
		return Response.ok(propLike).build();
	}
	
	@GET
	@Path("/getPropPerson/{personID}")
	public Response getPropPerson(@PathParam("personID") String id){
		PropositionController propCtrl = new PropositionController();
		if(propCtrl.getPropPerson(id) != null){
			return Response.ok(propCtrl.getPropPerson(id)).build();
		}
		return Response.status(Status.BAD_REQUEST).build();		
	}
	
	@GET
	@Path("/getDenunce")
	public Response getDenunce(){
		PropositionController propCtrl = new PropositionController();
		String denunce = propCtrl.getDenunce();
		if(denunce != null){
			return Response.ok(denunce).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}
	@POST
	@Path("/denunce/{propositionID}")
	public Response denunce(@PathParam("propositionID") String propositionID){
		PropositionController propCtrl = new PropositionController();
		if(propCtrl.denunce(propositionID)){
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
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
	public Response update(PropositionReduce propositionReduce){
		PropositionController propCtrl = new PropositionController();
		return Response.ok(propCtrl.update(propositionReduce)).build();
		
	}

}
