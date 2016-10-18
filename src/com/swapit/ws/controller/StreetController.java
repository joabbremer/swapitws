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
					StrTypeCtrl.toEntity(streetModel.getStreettype()),
					streetModel.getName(),
					streetModel.getComplement(),
					districtCtrl.toEntity(streetModel.getDistrict()),
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
	public StreetModel toModel(List<Street> streetEntity){
		StreetTypeController strTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		
		StreetModel streetModel = new StreetModel();
		for (Street street : streetEntity) {
			streetModel = new StreetModel(street.getStreetid(),
											strTypeCtrl.toModel(street.getStreettypeid()),
											street.getName(),
											street.getComplement(),
											districtCtrl.toModel(street.getDistrictid()),
											street.getZipcode());
			
		}
		
		
		return streetModel;
	}
	public List<StreetModel> toModelList(List<Street> streetEntity){
		StreetTypeController strTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		
		List<StreetModel> streetModel = new ArrayList<StreetModel>();
		for (Street street : streetEntity) {
			streetModel.add(new StreetModel(street.getStreetid(),
											strTypeCtrl.toModel(street.getStreettypeid()),
											street.getName(),
											street.getComplement(),
											districtCtrl.toModel(street.getDistrictid()),
											street.getZipcode()));
			
		}
		
		
		return streetModel;
	}

	public StreetModel getByCEP(String cep) {
		StreetDAO streetDao = new StreetDAO();
		List<Street> street = new ArrayList<Street>();
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

	public StreetModel getbyID(String streetID) {
		StreetDAO streetDao = new StreetDAO();
		List<Street> street = new ArrayList<Street>();
		try {
			street = streetDao.selectID(streetID);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		return toSingleModel(street);
	}

	private StreetModel toSingleModel(List<Street> streetEntity) {
		StreetTypeController strTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		
		StreetModel streetModel = null;
		for (Street street : streetEntity) {
			streetModel = new StreetModel(street.getStreetid(),
											strTypeCtrl.toModel(street.getStreettypeid()),
											street.getName(),
											street.getComplement(),
											districtCtrl.toModel(street.getDistrictid()),
											street.getZipcode());
			
		}		
		return streetModel;
	}

}
