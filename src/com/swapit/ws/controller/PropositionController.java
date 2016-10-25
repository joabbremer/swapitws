package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.swapit.ws.dao.PropositionDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Proposition;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.StreetModel;
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
		PropositionReduce propReduce = addressCtrl.reduceAddressProposition(toModel(prop));
		return toJson(propReduce);
		
	}
	
	

	public boolean save(PropositionReduce propositionReduce) {
		PropositionDAO propDao = new PropositionDAO();
		PropositionModel propositionModel =  propositionComplete(propositionReduce);
		
		try {
			return propDao.save(toEntity(propositionModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}		
		return false;
	};
	
	

	public boolean update(PropositionModel propositionModel) {
		PropositionDAO propDao = new PropositionDAO();
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
	
	private String toJson(PropositionReduce propReduce) {
		Gson gson = new Gson();
		return gson.toJson(propReduce);
	}
	
	private PropositionModel propositionComplete(PropositionReduce propositionReduce) {
		
		PersonController personCtrl = new PersonController();
		
		AddressReduce addressReduce =  propositionReduce.getAddressReduce();
		StreetController streetCtrl = new StreetController();
		StreetModel streetModel = streetCtrl.getbyID(addressReduce.getStreetid());
		AddressModel addressModel = new AddressModel();
		addressModel.setStreet(streetModel);
				
		PropositionModel propModel = new PropositionModel(creatID(propositionReduce.getPropositionId()),
															propositionReduce.getTitle(),
															propositionReduce.getDescription(),
															addressModel,
															propositionReduce.getPrice(),
															propositionReduce.getPriceCatInterest(),
															propositionReduce.getTotalPrice(),
															propositionReduce.getCategory(),
															propositionReduce.getInterest_category(),
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
					   proposition.getInterest_category(),
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
					   proposition.getInterest_category(),
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
											propModel.getInterest_category(),
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
											propModel.getInterest_category(),
											personCtrl.toEntity(propModel.getPersonId()),
											propImgCtrl.toEntity(propModel.getImage()),
											propModel.getPublish_date(),
											propModel.getRemovel_date()));
						
		}
		
		return proposition;
	}

	




}
