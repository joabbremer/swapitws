package com.swapit.ws.main;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import com.swapit.ws.dao.EntitiManager;
import com.swapit.ws.dao.PersonDAO;
import com.swapit.ws.dao.PropositionDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;
import com.swapit.ws.entities.Category;
import com.swapit.ws.entities.Favorite;
import com.swapit.ws.entities.Image;
import com.swapit.ws.entities.Person;
import com.swapit.ws.entities.Proposition;



public class Main {

	public static void main(String[] args) throws ConnectException {
		
		EntitiManager em = new EntitiManager();
		em.getEntityManager();
		
		List<Category> cate = new ArrayList<Category>();
		cate.add(new Category(UUID.randomUUID().toString(), "Teste", null,"blue","tito"));
		List<Image> img = new ArrayList<Image>();
		img.add(new Image(UUID.randomUUID().toString()));
		BigDecimal prics = new BigDecimal(0);
		List<Proposition> prop = new ArrayList<Proposition>();
		
		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   Date date = new Date();
		List<Person> per = new ArrayList<Person>();
		List<Favorite> fav = new ArrayList<Favorite>();
		fav.add(new Favorite("2d2d56ed-ad6d-48fb-83b2-3b13a024c389", "e8567a26-cb79-47f8-b9c4-2ae1f919f395"));
		per.add(new Person(UUID.randomUUID().toString(),
				"joab.bremer@gmail.com",
				"123456",
				"joab bremer",
				"96447503",
				"m",
				fav,
				new Address(UUID.randomUUID().toString(), "Rua gomercindo", "Falofito", "Brejo", 0, "pr", "8150000")));
		prop.add(new Proposition(UUID.randomUUID().toString(),"curitiba", "Teste", "Teste", prics, prics, "PR", "Teste", prics, "81580000",date, img, cate,per));
		PropositionDAO proDao = new PropositionDAO();
		for (Proposition proposition : prop) {
			proDao.save(proposition);
		}


		
		
		
		//List<Person> p = pson.listAll();
		//for (Person person : p) {
		//	System.out.println("Out" + person.getPersonName());
		//}
			
		//pson.save(new Person());
		
		
		
		//List<PersonEntity> list = pson.listAll();
		//for (PersonEntity personEntity : list) {
		//	System.out.println("e-mail:" + personEntity.getEmail());
		//}

		//EntityManager em = EntitiManager.getEntityManager();
		
		
		//List<cate>
		//List<Category> cater = new ArrayList<Category>();
		//cater.add(new Category("Automoveis"));
				
		//em.getTransaction().begin();
		//em.merge(cater);
		//em.getTransaction().commit();
		
		
		//List<Category> cat = em.createNamedQuery("Category.findAll").getResultList();
		//for (Category category : cat) {
		//	System.out.println("cat:" + category.getCategoryName());
		//}
	}

	

}
