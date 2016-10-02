package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.Collection;
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
											addressCtrl.toEntity(propModel.getAddressId()),
											propModel.getPrice(),
											propModel.getPriceCatInterest(),
											propModel.getTotalPrice(),
											categoryCtrl.toEntity(propModel.getCategoryId()),
											propModel.getInterest_category(),
											personCtrl.toEntity(propModel.getPersonId()),
											propImgCtrl.toEntity(propModel.getImageId()),
											propModel.getPublish_date(),
											propModel.getRemovel_date()));
			
			//proposition.addAll((Collection<? extends Proposition>) propModel.getClass().cast(propModel));
			
			
			
		}
		
		return proposition;
	};


}
