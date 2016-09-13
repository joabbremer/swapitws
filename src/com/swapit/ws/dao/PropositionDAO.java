package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Proposition;

public class PropositionDAO implements PojoInterfaceDAO<Proposition> {

	@Override
	public List<Proposition> listAll() throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition select(String id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Proposition obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean save(Proposition proposition) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(proposition);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Proposition obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

}
