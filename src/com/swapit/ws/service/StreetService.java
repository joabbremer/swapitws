package com.swapit.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.swapit.ws.controller.StreetController;

@Path("/street")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StreetService {
	
	@GET
	@Path("/getbycep/{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByCEP(@PathParam("cep") String cep){
		StreetController streetCtrl = new StreetController();
		return Response.ok(streetCtrl.getByCEP(cep)).build();
	}

}
