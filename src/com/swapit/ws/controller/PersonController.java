package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private PersonModel CreatID(PersonModel personModel){
		personModel.setPersonId(UUID.randomUUID().toString());
		AddressModel addrresModel = personModel.getAddresses();
		addrresModel.setAddressId(UUID.randomUUID().toString());
		personModel.setAddresses(addrresModel);
		return personModel;
	};
	
	public PersonModel toModel(Person person){
		FavoriteController favoriteCtrl = new FavoriteController();
		AddressController addressCtrl = new AddressController();
		return new PersonModel(person.getPersonId(),
				person.getEmail(),
				person.getPassword(),
				person.getPersonName(),
				person.getPhone(),
				person.getSex(),
				favoriteCtrl.toModel(person.getFavorite()),
				addressCtrl.toModel(person.getAddresses()));
	};
	
	public List<PersonModel> toModel(List<Person> personEntity){
		AddressController addressCtrl = new AddressController();
		FavoriteController favoriteCtrl = new FavoriteController();
		List<PersonModel> personModel = new ArrayList<PersonModel>();
		for (Person person : personEntity) {
			personModel.add(new PersonModel(person.getPersonId(),
					person.getEmail(),
					person.getPassword(),
					person.getPersonName(),
					person.getPhone(),
					person.getSex(),
					favoriteCtrl.toModel(person.getFavorite()),
					addressCtrl.toModel(person.getAddresses())));
			
		}
		
		return personModel;
		
	};
	
	public Person toEntity(PersonModel personModel){
		FavoriteController favoriteCtrl = new FavoriteController();
		AddressController addressCtrl = new AddressController();
		return new Person(personModel.getPersonId(),
				personModel.getEmail(),
				personModel.getPassword(),
				personModel.getPersonName(),
				personModel.getPhone(),
				personModel.getSex(),
				favoriteCtrl.toEntity(personModel.getFavorite()),
				addressCtrl.toEntity(personModel.getAddresses()));
		 
	};
	
	public String toJson(List<PersonModel> personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}
	public String toJson(PersonModel personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}

	

	

	

}
