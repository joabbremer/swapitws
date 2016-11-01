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
	public Boolean update(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			em.close();
			response =  true;
		} catch (Exception e) {
			response = false;
		}
		return response;
		
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
	public Boolean delete(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		em.detach(person);
		
		Boolean response;
		try {
			em.getTransaction().begin();
			em.remove(em.merge(person));
			em.getTransaction().commit();
			em.close();
			response = true;
		} catch (Exception e) {
			response = false;
			e.printStackTrace();
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<Person> login(String email, String password) throws ConnectException {		
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("loginPerson");
		query.setParameter("email",email);
		query.setParameter("password",password);
		return query.getResultList();
	}


	public List<Person> findbyEmail (String email) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("findPersonEmail");
		query.setParameter("email",email);
		return	query.getResultList();
		
	}


	

}
