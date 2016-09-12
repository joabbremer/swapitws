package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public List<Person> select(int id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person save(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Person obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

}
