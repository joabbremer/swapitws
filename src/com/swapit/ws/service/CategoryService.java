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

import com.swapit.ws.controller.CategoryController;
import com.swapit.ws.model.CategoryModel;

@Path("/category")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CategoryService {
	
	@GET()
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		CategoryController catCtrl = new CategoryController();
		return Response.ok(catCtrl.getALL()).build();
	}
	
	@GET
	@Path("/getbyID/{id}")
	public Response getbyID(@PathParam("id") String id){
		CategoryController catCtrl = new CategoryController();
		return Response.ok(catCtrl.getbyID(id)).build();
		
	}
	@GET
	@Path("/getParent/{id}")
	public Response getParent(@PathParam("id") String parentId){
		CategoryController catCtrl = new CategoryController();
		return Response.ok(catCtrl.getParent(parentId)).build();
		
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(CategoryModel categoryModel) {
		CategoryController catCtrl = new CategoryController();
		if(catCtrl.save(categoryModel)){
			return Response.status(Status.OK).build();			
		}				
		return Response.status(Status.BAD_REQUEST).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(CategoryModel categoryModel) {
		CategoryController catCtrl = new CategoryController();
		if(catCtrl.update(categoryModel)){
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}
				
	

}
