package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Street;

public class StreetDAO implements PojoInterfaceDAO<Street> {

	@Override
	public List<Street> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		return em.createNamedQuery("findAllState").getResultList();
	}

	@Override
	public Street select(String zipcode) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectCEP");
		query.setParameter("zipcode",zipcode);
		return (Street) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Street> selectCEP(String zipcode) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectCEP");
		query.setParameter("zipcode",zipcode);
		return query.getResultList();
	}

	@Override
	public Boolean update(Street obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Street obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Street obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Street> selectID(String streetID) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectIDstreet");
		query.setParameter("streetID",streetID);
		return query.getResultList();
		
		
	}

}
