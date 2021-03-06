package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import com.google.gson.Gson;
import com.swapit.ws.dao.PersonDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;
import com.swapit.ws.entities.Favorite;
import com.swapit.ws.entities.Person;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.FavoriteModel;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.StreetModel;
import com.swapit.ws.model.reduce.AddressReduce;
import com.swapit.ws.model.reduce.PersonReduce;
import com.swapit.ws.model.reduce.PropositionReduce;


public class PersonController {
	
	public String getALL() {
		PersonDAO personDao = new PersonDAO();
		List<Person> person = null;
		try {
			person = personDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return toJson(toModelList(person));
	};
	public List<PersonModel> getForActive() {
		PersonDAO personDao = new PersonDAO();
		List<Person> person = null;
		try {
			person = personDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return toModelList(person);
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
	
	public PersonModel getPersonModel(String id){
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		if(person != null){
			PersonModel perModel = toModel(person);
			if(perModel.getBlocked() != 4){
				return perModel;
			}		
		}
		return null;
	};
	
	public String getPersonForActive(String id){
		PersonDAO personDao = new PersonDAO();
		Person person = null;
		try {
			person = personDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		if(person != null && person.getBlocked() == 2){
			return toJson(toModel(person));
		}
		return null;
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
			return save;
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateService(PersonModel personModel) {
		PersonDAO personDao = new PersonDAO();
		try {
			personDao.update(toEntity(personModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
	}

	public Boolean update(PersonReduce personReduce) {
		PersonDAO personDao = new PersonDAO();	
		PersonModel personModel =  personComplete(personReduce);
		personModel = CreatID(personModel);
		removeProposition(personModel.getBlocked(), personModel.getPersonId());
		try {
			return personDao.update(toEntity(personModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void removeProposition(int blocked, String personId) {
		if(blocked == 4 && personId != null){
			PropositionController propCtrl = new PropositionController();
			List<PropositionReduce> propList = propCtrl.getPropPersonModel(personId);
			for (PropositionReduce propositionReduce : propList) {
				propositionReduce.setRemovel_date(new Date());
				propCtrl.update(propositionReduce);
			}
		}
		
	}
	public PersonModel personComplete(PersonReduce personReduce) {
		
		AddressReduce addressReduce =  personReduce.getAddressReduce();
		
		AddressController addrCtrl = new AddressController();
		AddressModel addrModel = null;
		if(addressReduce != null){
			addrModel = addrCtrl.getbyID(addressReduce.getAddressid());
		}
		
		
		StreetController streetCtrl = new StreetController();

		StreetModel streetModel = null;
		if(addrModel != null){
			streetModel = streetCtrl.getbyID(addrModel.getStreet().getStreetid());
			addrModel.setStreet(streetModel);
			addrModel.setAddressId(addressReduce.getAddressid());
			if(addressReduce.getNumber() != null){
				addrModel.setNumber(addressReduce.getNumber());
			}
			
		}
		PersonModel personModel = getPersonModel(personReduce.getPersonId());
		personModel.setPersonId(personReduce.getPersonId());
		if(personReduce.getPersonName() != null){
			personModel.setPersonName(personReduce.getPersonName());
		}
		if(personReduce.getEmail() != null){
			personModel.setEmail(personReduce.getEmail());
		}
		if(personReduce.getPhone() != null){
			personModel.setPhone(personReduce.getPhone());
		}
		if(personReduce.getPassword() != null){
			personModel.setPassword(personReduce.getPassword());
		}
		if(personReduce.getSex() != 'n'){
			personModel.setSex(personReduce.getSex());
		}
		
		personModel.setBlocked(personReduce.getBlocked());
		
		if(personReduce.getLevel() != null){
			personModel.setLevel(personReduce.getLevel());
		}
		if(personReduce.getFavorite() != null){
			personModel.setFavorite(personReduce.getFavorite());
		}
		if(addrModel != null){
			personModel.setAddress(addrModel);
		}


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
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		if(person.size() != 0){
			PersonModel perModel = toModel(person);
			if(perModel.getBlocked() == 0){
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
			if(perModel.getBlocked() == 0){
				return toJson(perModel);
			}		
		}
		return null;
	}
	
	public boolean recoverPassWord(String email) {
		PersonDAO personDao = new PersonDAO();
		List<Person> person = new ArrayList<Person>();
		boolean responseRecover = false;
		try {
			person = personDao.findbyEmail(email);
		} catch (ConnectException e) {
			e.printStackTrace();
		}	
		if(person.size() != 0){
			PersonModel perModel = toModel(person);
			if(perModel.getBlocked() == 0){
				perModel.setBlocked(3);
				updateService(perModel);
				responseRecover = true;
			}		
		}
		return responseRecover;
	}
	


	private PersonModel CreatID(PersonModel personModel){
		if(personModel.getPersonId() == null){
			personModel.setPersonId(UUID.randomUUID().toString());
		}		
		AddressModel addrresModel = personModel.getAddres();
		
		if(addrresModel != null){		
			if(addrresModel.getAddressId() == null){
				addrresModel.setAddressId(UUID.randomUUID().toString());
				personModel.setAddress(addrresModel);
				
			}
			
		}
		List<FavoriteModel> favModel = personModel.getFavorite();
		FavoriteController favCtrl = new FavoriteController();
		if(favModel != null){
			List<FavoriteModel> favModelCID = favCtrl.cretID(favModel);
			personModel.setFavorite(favModelCID);
			
		}
		return personModel;
	};
	
	public PersonModel toModel(Person person){
		AddressController addressCtrl = new AddressController();
		FavoriteController favCtrl = new FavoriteController();
		
		List<FavoriteModel> favoriteModel = new ArrayList<FavoriteModel>();
		AddressModel addressModel = new AddressModel();
		if(person.getFavorite() != null){
			favoriteModel = favCtrl.toModelList(person.getFavorite());
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
		List<FavoriteModel> favoriteModel = new ArrayList<FavoriteModel>();
		AddressModel addresModel = new AddressModel();
		AddressController addressCtrl = new AddressController();
		List<PersonModel> personModel = new ArrayList<PersonModel>();
		FavoriteController favCtrl = new FavoriteController();
		
		
		for (Person person : personEntity) {
			if(person.getFavorite() != null){
				favoriteModel = favCtrl.toModelList(person.getFavorite());
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
		List<FavoriteModel> favoriteModel = new ArrayList<FavoriteModel>();
		AddressModel addresModel = new AddressModel();
		AddressController addressCtrl = new AddressController();
		PersonModel personModel = new PersonModel();
		FavoriteController favCtrl = new FavoriteController();
		
		
		
		for (Person person : personEntity) {
			if(person.getFavorite() != null){
				favoriteModel = favCtrl.toModelList(person.getFavorite());
			}
			if(person.getAddress() != null){
				addresModel = addressCtrl.toModel(person.getAddress());
			}
			
			personModel = new PersonModel(person.getPersonId(),
					person.getPersonName(),
					person.getEmail(),
					person.getPhone(),
					person.getPassword(),
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
			List<Favorite> favorite = null;
			Address address = null;
			AddressController addressCtrl = new AddressController();
			FavoriteController favCtrl = new FavoriteController();
			if(personModel.getFavorite() != null){
				favorite = new ArrayList<Favorite>();
				favorite = favCtrl.toEntityList(personModel.getFavorite());
						
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
		FavoriteController favCtrl = new FavoriteController();
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
								  favCtrl.toEntityList(persoModel.getFavorite()),
								  addressCtrl.toEntity(persoModel.getAddres())));
		}
		return person;
	}


	
	

	

	


	

	

}
