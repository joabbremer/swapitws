package com.swapit.ws.dao;


import java.util.List;

import javax.persistence.EntityManager;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.PropositionImage;

public class PropositionIMGDAO implements PojoInterfaceDAO<PropositionImage> {

	@Override
	public List<PropositionImage> listAll() throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropositionImage select(String id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(PropositionImage obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(PropositionImage propositionImage) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
		    em.persist(propositionImage);
			em.getTransaction().commit();
			em.close();
			response =  true;
			
		} catch (Exception e) {
			response = false;
		}		
		return response;
	}

	@Override
	public Boolean delete(PropositionImage obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

}
