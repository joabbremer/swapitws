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
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.StateModel;
import com.swapit.ws.model.StreetModel;
import com.swapit.ws.model.StreetTypeModel;
import com.swapit.ws.model.reduce.AddressReduce;
import com.swapit.ws.model.reduce.PersonReduce;
import com.swapit.ws.model.reduce.PropositionReduce;

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
		if(addressEntity != null){
			return new AddressModel(addressEntity.getAddressId(),
					streetCtrl.toModel(addressEntity.getStreetid()),
					addressEntity.getNumber());
		}
		return null;
			
		
			
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
		if(addressModel.getAddressId() != null){
			return new Address(addressModel.getAddressId(),
					streetCtrl.toEntity(addressModel.getStreet()),
					addressModel.getNumber());
		}
		return null;
		
	
	};
	
	public PersonReduce reduceAddressPerson(PersonModel personModel){
		AddressModel addressModel = personModel.getAddres();
		StreetModel streetModel = null;
		if(addressModel != null){
			streetModel = addressModel.getStreet();
		}
		;
		StreetTypeModel streetType = null;
		DistrictModel districtModel = null;
		if(streetModel != null){
			streetType = streetModel.getStreettype();
			districtModel = streetModel.getDistrict();
		}
		CityModel cityModel = null;
		if(districtModel != null){
			cityModel =  districtModel.getCity();
		}
		StateModel stateModel = null;
		if(cityModel != null){
			stateModel = cityModel.getState();
		}
		CountryModel countryModel = null;
		if(stateModel != null){
			countryModel = stateModel.getCountry();
		}
		
		AddressReduce simpleAddress = null;
		if(streetModel != null){
			simpleAddress = new AddressReduce(streetModel.getStreetid(),
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
		}
		
		
		
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
	
	public PropositionReduce reduceAddressProposition(PropositionModel propositionModel){
		AddressModel addressModel = propositionModel.getAddress();
		StreetModel streetModel = null;
		if(addressModel != null){
			streetModel = addressModel.getStreet();
		}
		StreetTypeModel streetType = null;
		DistrictModel districtModel = null;
		if(streetModel != null){
			streetType = streetModel.getStreettype();
			districtModel = streetModel.getDistrict();
		}
		CityModel cityModel = null;
		if(districtModel != null){
			cityModel =  districtModel.getCity();
		}
		StateModel stateModel = null;
		if(cityModel != null){
			stateModel = cityModel.getState();
		}
		CountryModel countryModel = null;
		if(stateModel != null){
			countryModel = stateModel.getCountry();
		}
		
		AddressReduce simpleAddress = null;
		if(streetType != null){
			simpleAddress = new AddressReduce(streetModel.getStreetid(),
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
		}
		
		
		PropositionReduce propReduce = new PropositionReduce(propositionModel.getPropositionId(),
															propositionModel.getTitle(),
															propositionModel.getDescription(),
															simpleAddress,
															propositionModel.getPrice(),
															propositionModel.getPriceCatInterest(),
															propositionModel.getTotalPrice(),
															propositionModel.getCategory(),
															propositionModel.getInterest_category(),
															reduceAddressPerson(propositionModel.getPersonId()),
															propositionModel.getImage(),
															propositionModel.getPublish_date(),
															propositionModel.getRemovel_date());
		
				
		
		
		return propReduce;
	}

}
