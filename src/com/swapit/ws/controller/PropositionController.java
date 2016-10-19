package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.swapit.ws.dao.PropositionDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Proposition;
import com.swapit.ws.model.PropositionModel;

public class PropositionController {
	
	public String getALL() {
		PropositionDAO propDao = new PropositionDAO();
		List<Proposition> prop = null;
		try {
			prop = propDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return toJson(toModel(prop));
	};
	
	public List<PropositionModel> getbyID(String id){
		PropositionDAO propDao = new PropositionDAO();
		List<Proposition> prop = null;
		try {
			prop = propDao.getbyid(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		return toModel(prop);
		
	}
	
	public boolean save(PropositionModel propositionModel) {
		PropositionDAO propDao = new PropositionDAO();
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
	

	public String toJson(List<PropositionModel> propModel){
		Gson gson = new Gson();
		return gson.toJson(propModel);
		
	};
	
	public List<PropositionModel> toModel(List<Proposition> propositionEntity){
		
		
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
