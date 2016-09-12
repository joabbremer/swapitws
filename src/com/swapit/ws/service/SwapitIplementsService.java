package com.swapit.ws.service;

import javax.ws.rs.core.Response;


public interface SwapitIplementsService<T> {
	
	public Response getAll();
	public Response getbyID(String id);
	public Response save(T obj);
	public Response update(String id);
	public Response delete(String id);
		

}

