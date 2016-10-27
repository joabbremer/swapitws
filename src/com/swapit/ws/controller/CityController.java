package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.swapit.ws.dao.CityDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.City;
import com.swapit.ws.entities.State;
import com.swapit.ws.model.CityModel;

public class CityController {
	
	public String getCityState(String stateID) {
		CityDAO cityDao = new CityDAO();
		State state = new State();
		state.setStateid(stateID);
		List<City> city = null;
		try {
			city = cityDao.selectCityState(state);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		return toJson(toModel(city));
	}

	public City toEntity(CityModel cityModel) {
		StateController stateCtrl = new StateController();
		return new City(cityModel.getCityid(),
						cityModel.getName(),
						cityModel.getZipcode(),
						stateCtrl.toEntity(cityModel.getState()));
	}

	public CityModel toModel(City city) {
		StateController stateCtrl = new StateController();
		return new CityModel(city.getCityid(),
							 city.getName(),
							 city.getZipcode(),
							 stateCtrl.toModel(city.getStateid()));
	}
	
	public List<CityModel> toModel(List<City> cityEntity) {
		StateController stateCtrl = new StateController();
		List<CityModel> cityModel = new ArrayList<>();
		for (City city : cityEntity) {
			cityModel.add(new CityModel(city.getCityid(),
					 city.getName(),
					 city.getZipcode(),
					 stateCtrl.toModel(city.getStateid())));
		}
		
		return cityModel;
	}
	public String toJson(List<CityModel> CityModel){
		Gson gson = new Gson();
		return gson.toJson(CityModel);
	}

	

}
