package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Street;

public class StreetDAO implements PojoInterfaceDAO<Street> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Street> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		List<Street> street = em.createNamedQuery("findAllState").getResultList();
		em.close();
		return street;
	}

	@Override
	public Street select(String zipcode) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectCEP");
		query.setParameter("zipcode",zipcode);
		Street street = (Street) query.getSingleResult();
		em.close();
		return street;
	}
	
	@SuppressWarnings("unchecked")
	public List<Street> selectCEP(String zipcode) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectCEP");
		query.setParameter("zipcode",zipcode);
		List<Street> street = query.getResultList();
		em.close();
		return street;
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
		List<Street> street = query.getResultList();
		em.close();
		return street;		
		
	}

}
