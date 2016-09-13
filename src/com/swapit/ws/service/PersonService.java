package com.swapit.ws.service;


import javax.ws.rs.Consumes;
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
import com.swapit.ws.entities.Person;
import com.swapit.ws.model.PersonModel;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonService {

	
	@GET()
	@Path("/getAll")
	
	public Response getAll() {
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.getALL()).build();
				
	}

	
	@GET
	@Path("/getbyID/{id}")
	public Response getbyID(@PathParam("id") String id) {
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.get(id)).build();
	}

	
	@POST
	@Path("/save")
	public Response save(String personModel) {
		System.out.println("Entrou");
		Gson gson = new Gson();
		gson.toJson(personModel);
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.save(personModel)).build();
	}

	
	@PUT
	@Path("/update/{id}")
	public Response update(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@DELETE
	@Path("delete/{id}")
	public Response delete(@PathParam("id") String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}

