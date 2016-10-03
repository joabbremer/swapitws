package com.swapit.ws.controller;

import com.swapit.ws.entities.State;
import com.swapit.ws.model.StateModel;

public class StateController {

	public State toEntity(StateModel stateModel) {
		CountryController countryContrl = new CountryController();
		return new State(stateModel.getStateid(),
						 stateModel.getAcronym(),
						 stateModel.getName(),
						 countryContrl.toEntity(stateModel.getCountryid()));
	}

	public StateModel toModel(State state) {
		CountryController countryContrl = new CountryController();
		return new StateModel(state.getStateid(),
							state.getAcronym(),
							state.getName(),
							countryContrl.toModel(state.getCountryid()));
	}

}
