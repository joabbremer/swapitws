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
import javax.ws.rs.core.Response.ResponseBuilder;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;

@Path("/person")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PersonService {

	
	@GET()
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("/login/{email}/{senha}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("email") String email,
						  @PathParam("senha") String senha){
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.login(email, senha)).build();
		
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBuilder save(PersonModel personModel) {
		PersonController personCtrl = new PersonController();
		if(personCtrl.save(personModel)){
			return Response.status(Response.Status.OK);
		}		
		return Response.status(Response.Status.BAD_REQUEST);
	}

	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(PersonModel personModel) {
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.update(personModel)).build();
	}

	
	@DELETE
	@Path("/delete")
	public Response delete(PersonModel personModel) {
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.delete(personModel)).build();
	}

	
	

}

