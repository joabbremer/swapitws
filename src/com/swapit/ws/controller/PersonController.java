package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.swapit.ws.dao.PersonDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Person;
import com.swapit.ws.model.PersonModel;


public class PersonController {
	
	public String getALL() {
		PersonDAO personDao = new PersonDAO();
		List<Person> person = null;
		try {
			person = personDao.listAll();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return toJson(toModel(person));
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
	public String toJson(List<PersonModel> personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}

}
