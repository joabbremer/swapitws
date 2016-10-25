package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.State;

public class StateDAO implements PojoInterfaceDAO<State> {

	@Override
	public List<State> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		return em.createNamedQuery("findAllState").getResultList();
	}

	@Override
	public State select(String id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(State obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(State obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(State obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

}
