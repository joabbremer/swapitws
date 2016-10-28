package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Category;
import com.swapit.ws.entities.Person;
import com.swapit.ws.entities.Proposition;

public class PropositionDAO implements PojoInterfaceDAO<Proposition> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		return em.createNamedQuery("findAllProposition").getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Proposition> getbyid(String id) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectIDproposition");
		query.setParameter("propositionId",id);
		return query.getResultList();
	}
	
	public List<Proposition> getPropLike(String word) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectPropLike");
		query.setParameter("word","%"+word+"%");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropPerson(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectPropPerson");
		query.setParameter("personId",person);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropCategory(Category category) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectPropCategory");
		query.setParameter("categoryID",category);
		return query.getResultList();
	}
	
	@Override
	public Proposition select(String id) throws ConnectException {
		return null;
	}

	@Override
	public Boolean update(Proposition proposition) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
			em.merge(proposition);
			em.getTransaction().commit();
			em.close();
			response =  true;
		} catch (Exception e) {
			response = false;
		}
		return response;
		
	}

	@Override
	public Boolean save(Proposition proposition) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
		    em.merge(proposition);
			em.getTransaction().commit();
			em.close();
			response =  true;
			
		} catch (Exception e) {
			response = false;
		}		
		return response;
	}

	@Override
	public Boolean delete(Proposition obj) throws ConnectException {
		return null;
		// TODO Auto-generated method stub
		
	}


	


	

}
