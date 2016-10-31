package com.swapit.ws.dao;

import java.util.List;

import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;
import com.swapit.ws.entities.Category;
import com.swapit.ws.entities.City;
import com.swapit.ws.entities.Person;
import com.swapit.ws.entities.Proposition;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.reduce.PropositionReduce;

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
	
	public List<Proposition> getPropLike(String title, Category category, String city, Double max, Double min) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		//String sqlCommand = "SELECT p FROM Proposition p JOINp.Address a JOIN a.Street s JOIN s.district d JOIN d.city c WHERE p.price BETWEEN :min AND :max AND p.title LIKE :title AND p.categoryId = :category AND c.cityid = :city";
		//Query query = em.createQuery(sqlCommand);
		System.out.println("Dentro da DAO antes");
		Query query = em.createNamedQuery("selectPropLike");
		query.setParameter("title","%"+title+"%");
		query.setParameter("category",category);
		query.setParameter("city",city);
		query.setParameter("max",max);
		query.setParameter("min",min);
		System.out.println("Depois dos param");
		System.out.println(query);
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
