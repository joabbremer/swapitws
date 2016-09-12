package com.swapit.ws.controller;

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
		for (Person person : personEntity) {
			new PersonModel(person.getPersonId(),
					person.getEmail(),
					person.getPassword(),
					person.getPersonName(),
					person.getPhone(),
					person.getSex(),
					person.getFavorite(),
					person.getAddresses());
		}
		
		return null;
		
	};
	public String toJson(List<PersonModel> personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}

}
