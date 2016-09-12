package com.swapit.ws.service;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;

@Path("/person")
public class PersonService implements SwapitIplementsService<PersonModel> {

	@Override
	@GET()
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.getALL()).build();
				
	}

	@Override
	@GET
	@Path("/getbyID/{id}")
	public Response getbyID(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@POST
	@Path("/save")
	public Response save(PersonModel personModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PUT
	@Path("/update/{id}")
	public Response update(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DELETE
	@Path("delete/{id}")
	public Response delete(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}

