package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.swapit.ws.dao.PropositionDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Category;
import com.swapit.ws.entities.Person;
import com.swapit.ws.entities.Proposition;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.CategoryModel;
import com.swapit.ws.model.CityModel;
import com.swapit.ws.model.CountryModel;
import com.swapit.ws.model.DistrictModel;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.StateModel;
import com.swapit.ws.model.StreetModel;
import com.swapit.ws.model.StreetTypeModel;
import com.swapit.ws.model.reduce.AddressReduce;
import com.swapit.ws.model.reduce.PropositionReduce;

public class PropositionController {
	
	public String getALL() {
		PropositionDAO propDao = new PropositionDAO();
		List<Proposition> prop = null;
		try {
			prop = propDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return toJson(toModelList(prop));
	};
	
	public List<PropositionModel> getForRelate() {
		PropositionDAO propDao = new PropositionDAO();
		List<Proposition> prop = null;
		try {
			prop = propDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return toModelList(prop);
	};
	
	
	public String getbyID(String id){
		PropositionDAO propDao = new PropositionDAO();
		AddressController addressCtrl = new AddressController();
		List<Proposition> prop = null;
		try {
			prop = propDao.getbyid(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		if(prop.size() != 0 && analyRemoved(prop)){
			PropositionReduce propReduce = addressCtrl.reduceAddressProposition(toModel(prop));
			return toJson(propReduce);
		}
		
		return null;
		
	}
	
	private boolean analyRemoved(List<Proposition> propositionEntity) {
		for (Proposition proposition : propositionEntity) {
			if(proposition.getRemovel_date() == null){
				return true;
			}
		}
		return false;
	}

	public String getPropCategory(String categoryID){
		Category Category = new Category();
		Category.setCategoryId(categoryID);
		PropositionDAO propDao = new PropositionDAO();
		List<Proposition> prop = null;
		try {
			prop = propDao.getPropCategory(Category);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		if(prop.size() != 0 && analyRemoved(prop)){
			List<PropositionModel> propModel = toModelList(prop);
			List<PropositionReduce> propReduceList  = propositionReduce(propModel);
			return toJsonReduceList(propReduceList);
		}
		return null;	
	}
	

	public String getPropLike(String title, String categoryID, String city, Double max, Double min) {
		PropositionDAO propDao = new PropositionDAO();
		CategoryController catCtrl = new CategoryController();
		List<Proposition> prop = null;
		try {
			prop = propDao.getPropLikeFrip(title, catCtrl.getCatEntityByID(categoryID), city, max, min);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		if(prop.size() != 0 && analyRemoved(prop)){
			List<PropositionModel> propModel = toModelList(prop);
			List<PropositionReduce> propReduceList  = propositionReduce(propModel);
			return toJsonReduceList(propReduceList);
		}
		return null;
		
	}
	
	public String getPropPerson(String personID){
		Person person = new Person();
		person.setPersonId(personID);
		PropositionDAO propDao = new PropositionDAO();
		List<Proposition> prop = null;
		try {
			prop = propDao.getPropPerson(person);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		if(prop.size() != 0 && analyRemoved(prop)){
			List<PropositionModel> propModel = toModelList(prop);
			List<PropositionReduce> propReduceList  = propositionReduce(propModel);
			return toJsonReduceList(propReduceList);
		}
		return null;
		
		
	}
	
	

	private List<PropositionReduce> propositionReduce(List<PropositionModel> propModel) {
		List<PropositionReduce> propReduce = new ArrayList<PropositionReduce>();
		for (PropositionModel propositionModel : propModel) {
			AddressModel addressModel = propositionModel.getAddress();
			StreetModel streetModel = null;
			if(addressModel != null){
				streetModel = addressModel.getStreet();
			}
			StreetTypeModel streetType = null;
			DistrictModel districtModel = null;
			if(streetModel != null){
				streetType = streetModel.getStreettype();
				districtModel = streetModel.getDistrict();
			}
			CityModel cityModel = null;
			if(districtModel != null){
				cityModel =  districtModel.getCity();
			}
			StateModel stateModel = null;
			if(cityModel != null){
				stateModel = cityModel.getState();
			}
			CountryModel countryModel = null;
			if(stateModel != null){
				countryModel = stateModel.getCountry();
			}
			
			AddressReduce simpleAddress = null;
			if(streetType != null){
				simpleAddress = new AddressReduce(addressModel.getAddressId(),
						streetModel.getStreetid(),
						streetModel.getZipcode(),
						streetType.getName() + streetModel.getName(),
						streetModel.getComplement(),
						addressModel.getNumber(),
						districtModel.getName(),
						cityModel.getName(),
						stateModel.getAcronym(),
						stateModel.getName(),
						countryModel.getAcronym(),
						countryModel.getName());
			}
			
			AddressController addCtrl = new AddressController();
			propReduce.add(new PropositionReduce(propositionModel.getPropositionId(),
					propositionModel.getTitle(),
					propositionModel.getDescription(),
					simpleAddress,
					propositionModel.getPrice(),
					propositionModel.getPriceCatInterest(),
					propositionModel.getTotalPrice(),
					propositionModel.getCategory(),
					propositionModel.getInterest_category(),
					addCtrl.reduceAddressPerson(propositionModel.getPersonId()),
					propositionModel.getImage(),
					propositionModel.getPublish_date(),
					propositionModel.getRemovel_date()));
			
					
			
			
			
		}
		
		return propReduce;
	}

	public boolean save(PropositionReduce propositionReduce) {
		PropositionDAO propDao = new PropositionDAO();
		PropositionModel propositionModel =  propositionComplete(propositionReduce);
		
		try {

			boolean save = propDao.save(toEntity(propositionModel));
			return save;

		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return false;
	};
	
	

	public boolean update(PropositionReduce propositionReduce) {
		PropositionDAO propDao = new PropositionDAO();
		PropositionModel propositionModel =  propositionComplete(propositionReduce);
		try {
			return propDao.update(toEntity(propositionModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private  String creatID(String propositionid){
		if(propositionid == null){
			return UUID.randomUUID().toString();
		}
		return propositionid;
		
	}

	public String toJson(List<PropositionModel> list){
		Gson gson = new Gson();
		return gson.toJson(list);
		
	};
	
	public String toJsonReduceList(List<PropositionReduce> list){
		Gson gson = new Gson();
		return gson.toJson(list);
		
	};
	
	
	private String toJson(PropositionReduce propReduce) {
		Gson gson = new Gson();
		return gson.toJson(propReduce);
	}
	
	private PropositionModel propositionComplete(PropositionReduce propositionReduce) {
		
		PersonController personCtrl = new PersonController();
		
		AddressReduce addressReduce =  propositionReduce.getAddressReduce();
		StreetController streetCtrl = new StreetController();
		AddressModel addressModel = new AddressModel();
		StreetModel streetModel = null;
		if(addressReduce != null){
			streetModel = streetCtrl.getbyID(addressReduce.getStreetid());
			addressModel.setStreet(streetModel);
		}		
		
		CategoryController catCtrl = new CategoryController();
		CategoryModel catModel = catCtrl.getModelbyID(propositionReduce.getCategory().getCategoryId());
		CategoryModel interest = null;
		if(propositionReduce.getInterest_category() != null){
			if(!propositionReduce.getInterest_category().equals("")){
				interest = propositionReduce.getInterest_category();
			}
			
		}
		
		
		AddressController addCtrl = new AddressController();		
		String addressID = addCtrl.creatID(addressReduce.getAddressid());
		addressModel.setAddressId(addressID);
		
		
		
		PropositionModel propModel = new PropositionModel(creatID(propositionReduce.getPropositionId()),
															propositionReduce.getTitle(),
															propositionReduce.getDescription(),
															addressModel,
															propositionReduce.getPrice(),
															propositionReduce.getPriceCatInterest(),
															propositionReduce.getTotalPrice(),
															catModel,
															interest,
															personCtrl.personComplete(propositionReduce.getPersonReduce()),
															propositionReduce.getImage(),
															propositionReduce.getPublish_date(),
															propositionReduce.getRemovel_date());
		
		
		
		return propModel;
	}
	
	public PropositionModel toModel(List<Proposition> propositionEntity){
		
		
		PropositionImageController  propImgCtrl = new PropositionImageController();
		PersonController personCtrl = new PersonController();
		CategoryController categoryCtrl = new CategoryController();
		AddressController addressCtrl = new AddressController();
		PropositionModel propModel = new PropositionModel();
		
		
		for (Proposition proposition : propositionEntity) {
			propModel = new PropositionModel(proposition.getPropositionId(),
					   proposition.getTitle(),
					   proposition.getDescription(),
					   addressCtrl.toModel(proposition.getAddressId()),
					   proposition.getPrice(),
					   proposition.getPriceCatInterest(),
					   proposition.getTotalPrice(),
					   categoryCtrl.toModel(proposition.getCategoryId()),
					   categoryCtrl.toModel(proposition.getInterest_category()),
					   personCtrl.toModel(proposition.getPersonId()),
					   propImgCtrl.toModel(proposition.getImageId()),
					   proposition.getPublish_date(),
					   proposition.getRemovel_date());
		}
		return propModel;
	}
	
	public List<PropositionModel> toModelList(List<Proposition> propositionEntity){
		
		
		PropositionImageController  propImgCtrl = new PropositionImageController();
		PersonController personCtrl = new PersonController();
		CategoryController categoryCtrl = new CategoryController();
		AddressController addressCtrl = new AddressController();
		List<PropositionModel> propModel = new ArrayList<PropositionModel>();
		
		
		for (Proposition proposition : propositionEntity) {
			propModel.add(new PropositionModel(proposition.getPropositionId(),
					   proposition.getTitle(),
					   proposition.getDescription(),
					   addressCtrl.toModel(proposition.getAddressId()),
					   proposition.getPrice(),
					   proposition.getPriceCatInterest(),
					   proposition.getTotalPrice(),
					   categoryCtrl.toModel(proposition.getCategoryId()),
					   categoryCtrl.toModel(proposition.getInterest_category()),
					   personCtrl.toModel(proposition.getPersonId()),
					   propImgCtrl.toModel(proposition.getImageId()),
					   proposition.getPublish_date(),
					   proposition.getRemovel_date()));
		}
		return propModel;
	}
	
	public Proposition toEntity(PropositionModel propModel) {
		PropositionImageController  propImgCtrl = new PropositionImageController();
		PersonController personCtrl = new PersonController();
		CategoryController categoryCtrl = new CategoryController();
		AddressController addressCtrl = new AddressController();
		Proposition proposition = new Proposition();	
		
		
			proposition = new Proposition(propModel.getPropositionId(),
											propModel.getTitle(),
											propModel.getDescription(),
											addressCtrl.toEntity(propModel.getAddress()),
											propModel.getPrice(),
											propModel.getPriceCatInterest(),
											propModel.getTotalPrice(),
											categoryCtrl.toEntity(propModel.getCategory()),
											categoryCtrl.toEntity(propModel.getInterest_category()),
											personCtrl.toEntity(propModel.getPersonId()),
											propImgCtrl.toEntity(propModel.getImage()),
											propModel.getPublish_date(),
											propModel.getRemovel_date());
						
		
		
		return proposition;
	}

	public List<Proposition> toEntity(List<PropositionModel> favorite) {
		PropositionImageController  propImgCtrl = new PropositionImageController();
		PersonController personCtrl = new PersonController();
		CategoryController categoryCtrl = new CategoryController();
		AddressController addressCtrl = new AddressController();
		List<Proposition> proposition = new ArrayList<Proposition>();		
		for (PropositionModel propModel : favorite) {
			proposition.add(new Proposition(propModel.getPropositionId(),
											propModel.getTitle(),
											propModel.getDescription(),
											addressCtrl.toEntity(propModel.getAddress()),
											propModel.getPrice(),
											propModel.getPriceCatInterest(),
											propModel.getTotalPrice(),
											categoryCtrl.toEntity(propModel.getCategory()),
											categoryCtrl.toEntity(propModel.getInterest_category()),
											personCtrl.toEntity(propModel.getPersonId()),
											propImgCtrl.toEntity(propModel.getImage()),
											propModel.getPublish_date(),
											propModel.getRemovel_date()));
						
		}
		
		return proposition;
	}

	

	




}
