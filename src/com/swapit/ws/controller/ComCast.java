package com.swapit.ws.controller;

public class ComCast {
	
	public <E> E to(Class<E> e){
	    Object obj = null;
		return e.cast(obj);
	}
	


}
