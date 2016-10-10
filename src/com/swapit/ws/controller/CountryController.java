package com.swapit.ws.controller;

import com.swapit.ws.entities.Country;
import com.swapit.ws.model.CountryModel;

public class CountryController {

	public Country toEntity(CountryModel countryModel) {
		return new Country(countryModel.getCountry(),
						   countryModel.getAcronym(),
						   countryModel.getName());
	}

	public CountryModel toModel(Country country) {
		return new CountryModel(country.getCountry(),
								country.getAcronym(),
								country.getName());
	}

}
