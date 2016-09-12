package com.swapit.ws.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntitiManager {

public static EntityManager getEntityManager(){
	EntityManager em = null;
		if(em == null){
			em = Persistence.createEntityManagerFactory("swapitws").createEntityManager();
		}
		return em;
	}
}
