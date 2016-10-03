package com.swapit.ws.controller;

import com.swapit.ws.entities.City;
import com.swapit.ws.model.CityModel;

public class CityController {

	public City toEntity(CityModel cityModel) {
		StateController stateCtrl = new StateController();
		return new City(cityModel.getCityid(),
						cityModel.getName(),
						cityModel.getZipcode(),
						stateCtrl.toEntity(cityModel.getStateid()));
	}

	public CityModel toModel(City city) {
		StateController stateCtrl = new StateController();
		return new CityModel(city.getCityid(),
							 city.getName(),
							 city.getZipcode(),
							 stateCtrl.toModel(city.getStateid()));
	}

}
