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
import javax.ws.rs.core.Response.Status;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.reduce.PersonReduce;

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
		System.out.println("entrou");
		return Response.ok(personCtrl.get(id)).build();
	}
	
	@GET
	@Path("/login/{email}/{senha}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("email") String email,
						  @PathParam("senha") String senha){
		PersonController personCtrl = new PersonController();
		
		if(personCtrl.login(email, senha) != null){
			return Response.ok(personCtrl.login(email, senha)).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
		
		
	}
	@GET
	@Path("/getbyemail/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getbyEmail(@PathParam("email") String email){
		PersonController personCtrl = new PersonController();
		
		if(personCtrl.getbyEmail(email) != null){
			return Response.ok(personCtrl.getbyEmail(email)).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
		
		
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(PersonModel personModel) {
		PersonController personCtrl = new PersonController();
		if(personCtrl.save(personModel)){
			return Response.status(Status.OK).build();			
		}				
		return Response.status(Status.BAD_REQUEST).build();
	}

	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(PersonReduce personReduce) {
		PersonController personCtrl = new PersonController();
		if(personCtrl.update(personReduce)){
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	
	@DELETE
	@Path("/delete")
	public Response delete(PersonModel personModel) {
		PersonController personCtrl = new PersonController();
		return Response.ok(personCtrl.delete(personModel)).build();
	}

	
	

}

