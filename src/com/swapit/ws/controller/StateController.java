package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.swapit.ws.dao.StateDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.State;
import com.swapit.ws.model.StateModel;

public class StateController {
	
	public String getAll(){
		StateDAO stateDao = new StateDAO();
		List<StateModel> stateModel = new ArrayList<StateModel>();
		try {
			stateModel = toModelList(stateDao.listAll());
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toJson(stateModel);
	}

	private List<StateModel> toModelList(List<State> listState) {
		List<StateModel> stateModel = new ArrayList<StateModel>();
		for (State state : listState) {
			stateModel.add(new StateModel(state.getStateid(),
					state.getAcronym(),
					state.getName(),
					 null));
		}
		return stateModel;
	}

	public State toEntity(StateModel stateModel) {
		CountryController countryContrl = new CountryController();
		return new State(stateModel.getStateid(),
						 stateModel.getAcronym(),
						 stateModel.getName(),
						 countryContrl.toEntity(stateModel.getCountry()));
	}

	public StateModel toModel(State state) {
		CountryController countryContrl = new CountryController();
		return new StateModel(state.getStateid(),
							state.getAcronym(),
							state.getName(),
							countryContrl.toModel(state.getCountry()));
	}
	
	public String toJson(List<StateModel> stateModel){
		Gson gson = new Gson();
		return gson.toJson(stateModel);
	}

}
