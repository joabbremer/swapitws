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
	
	public String toJson(List<PropositionModel> propModel){
		Gson gson = new Gson();
		return gson.toJson(propModel);
		
	};
	
	public List<PropositionModel> toModel(List<Proposition> propositionEntity){
		PersonController personCtrl = new PersonController();
		CategoryController categoryCtrl = new CategoryController();
		ImageController imgCtrl = new ImageController();
		List<PropositionModel> propModel = new ArrayList<PropositionModel>();
		for (Proposition proposition : propositionEntity) {
			propModel.add(new PropositionModel(proposition.getPropositionId(),
					proposition.getCity(),
					proposition.getDescription(),
					proposition.getInterestCategory(),
					proposition.getPrice(),
					proposition.getPriceCatInterest(),
					proposition.getState(),
					proposition.getTitle(),
					proposition.getTotalPrice(),
					proposition.getZipCode(),
					proposition.getPublish_date(),
					imgCtrl.toModel(proposition.getImage_id()) ,
					categoryCtrl.toModel(proposition.getProp_category()) ,
					personCtrl.toModel(proposition.getPersonId())));
		}
		return propModel;
	};

}
