package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Category;

public class CategoryDAO implements PojoInterfaceDAO<Category> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listAll() throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		List<Category> cat = em.createNamedQuery("findAllCategory").getResultList();
		return cat;
	}

	@Override
	public Category select(String id) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Category> query = em.createNamedQuery("selectIDCategoty", Category.class);
		query.setParameter("categoryId",id);
		Category cat = query.getSingleResult();
		return  cat;
	}
	public List<Category> selectShow(String id) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Category> query = em.createNamedQuery("selectIDCategoty", Category.class);
		query.setParameter("categoryId",id);
		List<Category> cat =  query.getResultList();
		return  cat;
	}
	
	public List<Category> getParent(String parentID) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		TypedQuery<Category> query = em.createNamedQuery("selectParentID", Category.class);
		query.setParameter("parentId",parentID);
		List<Category> cat =  query.getResultList();
		return  cat;
	}

	@Override
	public Boolean update(Category category) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
			em.merge(category);
			em.getTransaction().commit();
			em.close();
			response =  true;
		} catch (Exception e) {
			response = false;
		}
		return response;
		
	}

	@Override
	public Boolean save(Category category) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
		    em.persist(category);
			em.getTransaction().commit();
			em.close();
			response =  true;
			
		} catch (Exception e) {
			response = false;
		}		
		return response;
	}

	public Boolean save(List<Category> category) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Boolean response;
		try {
			em.getTransaction().begin();
		    em.persist(category);
			em.getTransaction().commit();
			em.close();
			response =  true;
			
		} catch (Exception e) {
			response = false;
		}		
		return response;
	}
	
	@Override
	public Boolean delete(Category obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
		
	}





}
