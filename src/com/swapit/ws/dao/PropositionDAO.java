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
		List<Proposition> prop = em.createNamedQuery("findAllProposition").getResultList();
		em.close();
		return prop;
	}

	
	@SuppressWarnings("unchecked")
	public List<Proposition> getbyid(String id) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectIDproposition");
		query.setParameter("propositionId",id);
		List<Proposition> prop = query.getResultList();
		em.close();
		return prop;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropLikeFrip(String title, Category category, String city, Double max, Double min) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();

		String consulting = "SELECT p FROM Proposition p "
			+ "INNER JOIN p.addressId a "
			+ "INNER JOIN a.streetid s "
			+ "INNER JOIN s.districtid d "
			+ "INNER JOIN d.cityid c "
			+ "WHERE p.price BETWEEN :min and :max  ";
		
		Query query = null;
		query = em.createQuery(consulting);
		boolean titleStatus = false, cityStatus = false, categoryStatus = false;
		if(!title.equals("null")){
			consulting += "AND p.title LIKE :title";
			titleStatus = true;
		}
		if(!city.equals("null")){
			consulting += "AND c.cityid = :city";
			cityStatus = true;
		}
		if(category != null){
			consulting += "AND p.categoryId = :category ";	
			categoryStatus = true;
		}		
		query = em.createQuery(consulting);		

		if(titleStatus){
			if(query.getParameter("title").getName().equals("title")){
				query.setParameter("title","%"+title+"%");
			}
		}
		if(cityStatus){
			if(query.getParameter("city").getName().equals("city")){
				query.setParameter("city",city);
			}			
		}
		if(categoryStatus){
			if(query.getParameter("category").getName().equals("category")){
				query.setParameter("category",category);
			}			
		}				
		query.setParameter("max",max);
		query.setParameter("min",min);
		
		List<Proposition> prop = query.getResultList();
		em.close();
		return prop;
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropPerson(Person person) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectPropPerson");
		query.setParameter("personId",person);
		List<Proposition> prop = query.getResultList();
		return prop;
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropCategory(Category category) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectPropCategory");
		query.setParameter("categoryID",category);
		List<Proposition> prop = query.getResultList();
		em.close();
		return prop;
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
