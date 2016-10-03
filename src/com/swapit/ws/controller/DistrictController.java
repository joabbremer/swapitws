package com.swapit.ws.controller;

import com.swapit.ws.entities.District;
import com.swapit.ws.model.DistrictModel;

public class DistrictController {

	public District toEntity(DistrictModel districtModel) {
		CityController cityCtrl = new CityController();
		return new District(districtModel.getDistrictid(),
							districtModel.getName(),
							cityCtrl.toEntity(districtModel.getCityid()));
	}

	public DistrictModel toModel(District district) {
		CityController cityCtrl = new CityController();
		return new DistrictModel(district.getDistrictid(),
								 district.getName(),
								 cityCtrl.toModel(district.getCityid()));
	}

}
