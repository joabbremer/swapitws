package com.swapit.ws.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Person;



public class PersonDAO implements PojoInterfaceDAO<Person> {


	@Override
	public List<Person> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		List<Person> person = em.createNamedQuery("findAllPersons",Person.class).getResultList();
		em.close();
		return person;
	}

	@Override
	public Person select(String id) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectIDPerson");
		query.setParameter("personId",id);
		Person person = (Person) query.getSingleResult();
		em.close();
		return person;
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
	public void updateActive(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
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


	public List<Person> login(String email, String password) throws ConnectException {		
		EntityManager em = EntitiManager.getEntityManager();
		TypedQuery<Person> query = em.createNamedQuery("loginPerson", Person.class);
		query.setParameter("email",email);
		query.setParameter("password",password);
		List<Person> person = query.getResultList();
		em.close();
		return person;
	}


	public List<Person> findbyEmail (String email) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		TypedQuery<Person> query = em.createNamedQuery("findPersonEmail", Person.class);
		query.setParameter("email",email);
		List<Person> person = query.getResultList();
		em.close();
		return	person;
		
	}


	

}
