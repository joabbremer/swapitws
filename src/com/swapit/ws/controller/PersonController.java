package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.swapit.ws.dao.PersonDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Person;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.PersonModel;


public class PersonController {
	
	public String getALL() {
		PersonDAO personDao = new PersonDAO();
		List<Person> person = null;
		try {
			person = personDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return toJson(toModel(person));
	};
	
	public String get(String id){
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return toJson(toModel(person));
	};
	
	public Boolean save(PersonModel personModel) {
		PersonDAO personDao = new PersonDAO();
		
		personModel = CreatID(personModel);
		try {
			return personDao.save(toEntity(personModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean update(PersonModel personModel) {
		PersonDAO personDao = new PersonDAO();		
		try {
			return personDao.update(toEntity(personModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean delete(PersonModel personModel) {
		PersonDAO personDao = new PersonDAO();
		try {
			return personDao.delete(toEntity(personModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String login(String email, String password) {
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.login(email, password);
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return toJson(toModel(person));
	}
	
	private PersonModel CreatID(PersonModel personModel){
		personModel.setPersonId(UUID.randomUUID().toString());
		//AddressModel addrresModel = personModel.getAddresid();
		//addrresModel.setAddressId(UUID.randomUUID().toString());
		//personModel.setAddresid(addrresModel);
		return personModel;
	};
	
	public PersonModel toModel(Person person){
		PropositionController propCtrl = new PropositionController();
		AddressController addressCtrl = new AddressController();
		return new PersonModel(person.getPersonId(),
				person.getPersonName(),
				person.getEmail(),
				person.getPhone(),
				person.getPassword(),
				person.getSex(),
				person.getBlocked());
				//propCtrl.toModel(person.getFavorite()),
				//addressCtrl.toModel(person.getAddresid()));
	};
	
	public List<PersonModel> toModel(List<Person> personEntity){
		AddressController addressCtrl = new AddressController();
		PropositionController propCtrl = new PropositionController();
		List<PersonModel> personModel = new ArrayList<PersonModel>();
		for (Person person : personEntity) {
			personModel.add(new PersonModel(person.getPersonId(),
					person.getPersonName(),
					person.getEmail(),
					person.getPhone(),
					person.getPassword(),
					person.getSex(),
					person.getBlocked()));
					//propCtrl.toModel(person.getFavorite()),
					//addressCtrl.toModel(person.getAddresid())));
			
		}		
		return personModel;
		
	};
	
	public Person toEntity(PersonModel personModel){
		PropositionController propCtrl = new PropositionController();
		AddressController addressCtrl = new AddressController();
		return new Person(personModel.getPersonId(),
				personModel.getPersonName(),
				personModel.getEmail(),
				personModel.getPhone(),
				personModel.getPassword(), 
				personModel.getSex(),
				personModel.getBlocked());
				//propCtrl.toEntity(personModel.getFavorite()), 
				//addressCtrl.toEntity(personModel.getAddresid()));
		
		
		
		
	};
	
	public String toJson(List<PersonModel> personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}
	public String toJson(PersonModel personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}
	
	public List<Person> toEntity(List<PersonModel> personModel) {
		AddressController addressCtrl = new AddressController();
		PropositionController propCtrl = new PropositionController();
		List<Person> person = new ArrayList<Person>();
		for (PersonModel persoModel : personModel) {
			person.add(new Person(persoModel.getPersonId(),
								  persoModel.getPersonName(),
								  persoModel.getEmail(),
								  persoModel.getPhone(),
								  persoModel.getPassword(),
								  persoModel.getSex(),
								  persoModel.getBlocked(),
								  propCtrl.toEntity(persoModel.getFavorite()),
								  addressCtrl.toEntity(persoModel.getAddresid())));
		}
		return person;
	}

	

	


	

	

}
