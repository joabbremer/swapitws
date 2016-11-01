package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;
import com.swapit.ws.entities.Category;
import com.swapit.ws.entities.City;
import com.swapit.ws.entities.District;
import com.swapit.ws.entities.Person;
import com.swapit.ws.entities.Proposition;
import com.swapit.ws.entities.Street;


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
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropLike(String title, Category category, String city, Double max, Double min) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectPropLike");
		query.setParameter("title","%"+title+"%");
		query.setParameter("category",category);
		query.setParameter("city",city);
		query.setParameter("max",max);
		query.setParameter("min",min);
		return query.getResultList();
		
		
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
		
		return query.getResultList();
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropLikeTes(String title, Category category, String city, Double max, Double priceMin) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		CriteriaBuilder builder  = em.getCriteriaBuilder();
		CriteriaQuery<Proposition> query = builder.createQuery(Proposition.class);        
		Root<Proposition> fromPropositionSection = query.from(Proposition.class);
		Root<Address> fromAddress = query.from(Address.class);
		
		Join<Proposition, Address> propositionJoin = fromPropositionSection.join("addressId");
		Join<Address, Street> addressJoin = fromPropositionSection.join("streetid");
		Join<Street, District> streetJoin = fromPropositionSection.join("districtid");
		Join<District, City> cityJoin = fromPropositionSection.join("cityid");
		
		Predicate predicate = builder.and();
		
		if(priceMin > 0){
			predicate = builder.and(predicate, builder.ge(fromPropositionSection.get("price"), priceMin));
			
		}
		
		
		TypedQuery<Proposition> typedQuery = em.createQuery(
			    query.select(fromPropositionSection )
			    .where(builder.and(builder.equal(propositionJoin, addressJoin),
			    				   builder.equal(propositionJoin.get("addressId"), "dbc29a86-9e0f-4c58-9464-ce3f3a6fa700")
			    		
			    		)));
		
		return typedQuery.getResultList();
		
		
		
		
		/*Query query = em.createNamedQuery("selectPropLike");
		query.setParameter("title","%"+title+"%");
		query.setParameter("category",category);
		query.setParameter("city",city);
		query.setParameter("max",max);
		query.setParameter("min",min);
		return query.getResultList();*/
		
		
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
