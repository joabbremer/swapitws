package com.swapit.ws.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Person;


public class PersonDAO implements PojoInterfaceDAO<Person> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		return em.createNamedQuery("findAllPersons").getResultList();
	}

	@Override
	public Person select(String id) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectIDPerson");
		query.setParameter("personId",id);
		return (Person) query.getSingleResult();
	}

	@Override
	public void update(Person obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean save(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
		    em.persist(person);
			em.getTransaction().commit();
			em.close();
			response =  true;
			
		} catch (Exception e) {
			response = false;
		}		
		return response;
	}

	@Override
	public void delete(Person obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

}
