package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.City;
import com.swapit.ws.entities.State;

public class CityDAO implements PojoInterfaceDAO<City>{

	@Override
	public List<City> listAll() throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City select(String id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<City> selectCityState(State state) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectCityState");
		query.setParameter("stateId",state);
		return  query.getResultList();
	}

	@Override
	public Boolean update(City obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(City obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(City obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

}
