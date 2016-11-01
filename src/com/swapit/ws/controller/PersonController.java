package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.google.gson.Gson;
import com.swapit.ws.dao.PersonDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;
import com.swapit.ws.entities.Person;
import com.swapit.ws.entities.Proposition;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.MessegesBuildModel;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.StreetModel;
import com.swapit.ws.model.reduce.AddressReduce;
import com.swapit.ws.model.reduce.PersonReduce;
import com.swapit.ws.service.SendMail;


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
		AddressController addressCtrl = new AddressController();
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		PersonReduce personReduce = addressCtrl.reduceAddressPerson(toModel(person));
		return toJson(personReduce);
	};
	
	public PersonReduce getTestReduce(String id){
		AddressController addressCtrl = new AddressController();
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		PersonReduce personReduce = addressCtrl.reduceAddressPerson(toModel(person));
		return personReduce;
	};
	
	public PersonModel getPersonModel(String id){
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		
		return toModel(person);
	};
	
	public Boolean save(PersonModel personModel) {
		PersonDAO personDao = new PersonDAO();
		personModel = CreatID(personModel);
		boolean save = false;
		List<Person> personValidate = new ArrayList<Person>();
		try {
			personValidate = personDao.findbyEmail(personModel.getEmail());
			if(personValidate.size() == 0){
				save = personDao.save(toEntity(personModel));
			}			
			MessegesBuildModel msgBuild = new MessegesBuildModel();
			if(save){
				SendMail sendMail = new SendMail();
				sendMail.sendMail("joab.bremer@gmail.com", personModel.getEmail(), "ACTIVE", "http://localhost:8080/swapitws/rs/person/active/"+personModel.getPersonId());
				
			}
			return save;
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean update(PersonReduce personReduce) {
		PersonDAO personDao = new PersonDAO();	
		PersonModel personModel =  personComplete(personReduce);
		personModel = CreatID(personModel);
		try {
			return personDao.update(toEntity(personModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public PersonModel personComplete(PersonReduce personReduce) {
		AddressReduce addressReduce =  personReduce.getAddressReduce();
		StreetController streetCtrl = new StreetController();
		AddressModel addressModel = new AddressModel();
		StreetModel streetModel = null;
		if(addressReduce != null){
			streetModel = streetCtrl.getbyID(addressReduce.getStreetid());
			addressModel.setStreet(streetModel);
			addressModel.setNumber(addressReduce.getNumber());
		}
		
		PersonController personCtrl = new PersonController();
		PersonModel personModel = personCtrl.getPersonModel(personReduce.getPersonId());
		
				
		/*PersonModel personModel = new PersonModel(personReduce.getPersonId(),
													personReduce.getPersonName(),
													personReduce.getEmail(),
													personReduce.getPhone(),
													personReduce.getPassword(),
													personReduce.getSex(),
													personReduce.getBlocked(),
													personReduce.getLevel(),
													personReduce.getFavorite(),
													addressModel);*/
		
		return personModel;
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
		List<Person> person = new ArrayList<Person>();
		try {
			person = personDao.login(email, password);
			System.out.println(person.size());
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		if(person.size() != 0){
			PersonModel perModel = toModel(person);
			if(perModel.getBlocked() != 1){
				return toJson(perModel);
			}		
		}
		return null;
	}
	
	public String getbyEmail(String email) {
		PersonDAO personDao = new PersonDAO();
		List<Person> person = new ArrayList<Person>();
		try {
			person = personDao.findbyEmail(email);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		if(person.size() != 0){
			PersonModel perModel = toModel(person);
			if(perModel.getBlocked() != 1){
				return toJson(perModel);
			}		
		}
		return null;
	}
	
	private PersonModel CreatID(PersonModel personModel){
		if(personModel.getPersonId() == null){
			personModel.setPersonId(UUID.randomUUID().toString());
		}		
		AddressModel addrresModel = personModel.getAddres();
		
		if(addrresModel != null){			
			addrresModel.setAddressId(UUID.randomUUID().toString());
			personModel.setAddress(addrresModel);
		}
		
		
		return personModel;
	};
	
	public PersonModel toModel(Person person){
		PropositionController propCtrl = new PropositionController();
		AddressController addressCtrl = new AddressController();
		List<PropositionModel> favoriteModel = new ArrayList<PropositionModel>();
		AddressModel addressModel = new AddressModel();
		if(person.getFavorite() != null){
			favoriteModel = propCtrl.toModelList(person.getFavorite());
		}
		if(person != null){
			if(person.getAddress() != null){
				addressModel = addressCtrl.toModel(person.getAddress());
			}
		}
		
		return new PersonModel(person.getPersonId(),
				person.getPersonName(),
				person.getEmail(),
				person.getPhone(),
				person.getPassword(),
				person.getSex(),
				person.getBlocked(),
				person.getLevel(),
				favoriteModel,
				addressModel);
	};
	
	public List<PersonModel> toModelList(List<Person> personEntity){
		List<PropositionModel> favoriteModel = new ArrayList<PropositionModel>();
		AddressModel addresModel = new AddressModel();
		AddressController addressCtrl = new AddressController();
		PropositionController propCtrl = new PropositionController();
		List<PersonModel> personModel = new ArrayList<PersonModel>();
		
		
		
		for (Person person : personEntity) {
			if(person.getFavorite() != null){
				favoriteModel = propCtrl.toModelList(person.getFavorite());
			}
			if(person.getAddress() != null){
				addresModel = addressCtrl.toModel(person.getAddress());
			}
			
			personModel.add(new PersonModel(person.getPersonId(),
					person.getPersonName(),
					person.getEmail(),
					person.getPhone(),
					person.getPassword(),
					person.getSex(),
					person.getBlocked(),
					person.getLevel(),
					favoriteModel,
					addresModel));
			
			favoriteModel = null;
			addresModel = null;
			
		}		
		return personModel;
		
	};
	public PersonModel toModel(List<Person> personEntity){
		List<PropositionModel> favoriteModel = new ArrayList<PropositionModel>();
		AddressModel addresModel = new AddressModel();
		AddressController addressCtrl = new AddressController();
		PropositionController propCtrl = new PropositionController();
		PersonModel personModel = new PersonModel();
		
		
		
		for (Person person : personEntity) {
			if(person.getFavorite() != null){
				favoriteModel = propCtrl.toModelList(person.getFavorite());
			}
			if(person.getAddress() != null){
				addresModel = addressCtrl.toModel(person.getAddress());
			}
			
			personModel = new PersonModel(person.getPersonId(),
					person.getPersonName(),
					person.getEmail(),
					person.getPhone(),
					person.getSex(),
					person.getBlocked(),
					person.getLevel(),
					favoriteModel,
					addresModel);
			
			favoriteModel = null;
			addresModel = null;
			
		}		
		return personModel;
		
	};
	

	public Person toEntity(PersonModel personModel){
		if(personModel != null){
			List<Proposition> favorite = new ArrayList<Proposition>();
			Address address = null;
			PropositionController propCtrl = new PropositionController();
			AddressController addressCtrl = new AddressController();
			if(personModel.getFavorite() != null){
				favorite =  propCtrl.toEntity(personModel.getFavorite());
			}
			if(personModel.getAddres() != null){
				address =  addressCtrl.toEntity(personModel.getAddres());
			}
			return new Person(personModel.getPersonId(),
					personModel.getPersonName(),
					personModel.getEmail(),
					personModel.getPhone(),
					personModel.getPassword(), 
					personModel.getSex(),
					personModel.getBlocked(),
					personModel.getLevel(),
					favorite,
					address);
		}
		return null;
		
	};
	
	public String toJson(List<PersonModel> personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}
	public String toJson(PersonModel personModel){
		Gson gson = new Gson();
		return gson.toJson(personModel);
	}
	public String toJson(PersonReduce personReduce){
		Gson gson = new Gson();
		return gson.toJson(personReduce);
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
								  persoModel.getLevel(),
								  propCtrl.toEntity(persoModel.getFavorite()),
								  addressCtrl.toEntity(persoModel.getAddres())));
		}
		return person;
	}

	

	

	


	

	

}
