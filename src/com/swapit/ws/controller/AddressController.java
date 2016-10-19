package com.swapit.ws.controller;


import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.dao.AddressDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.CityModel;
import com.swapit.ws.model.CountryModel;
import com.swapit.ws.model.DistrictModel;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.StateModel;
import com.swapit.ws.model.StreetModel;
import com.swapit.ws.model.StreetTypeModel;
import com.swapit.ws.model.reduce.AddressReduce;
import com.swapit.ws.model.reduce.PersonReduce;

public class AddressController {
	
	public AddressModel getbyID(String addressID){
		AddressDAO addressDao = new AddressDAO();
		List<Address> address = new ArrayList<Address>();
		try {
			address = addressDao.getbyID(addressID);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toModel(address);
	}
	
	public AddressModel toModel(Address addressEntity){		
		StreetController streetCtrl = new StreetController();
		return new AddressModel(addressEntity.getAddressId(),
								streetCtrl.toModel(addressEntity.getStreetid()),
								addressEntity.getNumber());
		
	}
	public AddressModel toModel(List<Address> addressEntity){	
		
		StreetController streetCtrl = new StreetController();	
		AddressModel addressModel = null;
		for (Address address : addressEntity) {
			addressModel = new AddressModel(address.getAddressId(),
												streetCtrl.toModel(address.getStreetid()),
												address.getNumber());
			
		}
		
		return addressModel;
	} 
	
	public Address toEntity(AddressModel addressModel){
		StreetController streetCtrl = new StreetController();		
		return new Address(addressModel.getAddressId(),
				streetCtrl.toEntity(addressModel.getStreet()),
				addressModel.getNumber());
	
	};
	
	public PersonReduce reduceAddress(PersonModel personModel){
		AddressModel addressModel = personModel.getAddres();
		StreetModel streetModel = addressModel.getStreet();
		StreetTypeModel streetType = streetModel.getStreettype();
		DistrictModel districtModel = streetModel.getDistrict();
		CityModel cityModel =  districtModel.getCity();
		StateModel stateModel = cityModel.getState();
		CountryModel countryModel = stateModel.getCountry();
		
		AddressReduce simpleAddress = new AddressReduce(streetModel.getStreetid(),
																	streetModel.getZipcode(),
																	streetType.getName() + streetModel.getName(),
																	streetModel.getComplement(),
																	addressModel.getNumber(),
																	districtModel.getName(),
																	cityModel.getName(),
																	stateModel.getAcronym(),
																	stateModel.getName(),
																	countryModel.getAcronym(),
																	countryModel.getName());
		
		System.out.println(personModel.getPersonId() + "Passou aqui");
		PersonReduce personReduce =  new PersonReduce(personModel.getPersonId(),
														personModel.getPersonName(),
														personModel.getEmail(),
														personModel.getPhone(),
														personModel.getPassword(),
														personModel.getSex(),
														personModel.getBlocked(),
														personModel.getLevel(),
														personModel.getFavorite(),
														simpleAddress);
		
		
		return personReduce;
	}

}
