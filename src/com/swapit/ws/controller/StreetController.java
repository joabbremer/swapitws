package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.swapit.ws.dao.StreetDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Street;
import com.swapit.ws.model.StreetModel;

public class StreetController {

	public Street toEntity(StreetModel streetModel) {
		StreetTypeController StrTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		return new Street(streetModel.getStreetid(),
					StrTypeCtrl.toEntity(streetModel.getStreettypeid()),
					streetModel.getName(),
					streetModel.getComplement(),
					districtCtrl.toEntity(streetModel.getDistrictid()),
					streetModel.getZipcode());
		 
	}

	public StreetModel toModel(Street streetEntity) {
		StreetTypeController StrTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		return new StreetModel(streetEntity.getStreetid(),
						StrTypeCtrl.toModel(streetEntity.getStreettypeid()),
						streetEntity.getName(),
						streetEntity.getComplement(),
						districtCtrl.toModel(streetEntity.getDistrictid()),
						streetEntity.getZipcode());
		 
	}

	public StreetModel getByCEP(String cep) {
		StreetDAO streetDao = new StreetDAO();
		Street street = new Street();
		try {
			street = streetDao.selectCEP(cep);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return toModel(street);
		
		
	}
	public String toJson(Street street){
		Gson gson = new Gson();
		return gson.toJson(street);
	}

}
