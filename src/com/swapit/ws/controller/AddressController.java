package com.swapit.ws.controller;


import com.swapit.ws.entities.Address;
import com.swapit.ws.model.AddressModel;

public class AddressController {
	
	public AddressModel toModel(Address addressEntity){		
		StreetController streetCtrl = new StreetController();
		return new AddressModel(addressEntity.getAddressId(),
								streetCtrl.toModel(addressEntity.getStreetid()),
								addressEntity.getNumber());
		
	}
	
	public Address toEntity(AddressModel addressModel){
		StreetController streetCtrl = new StreetController();		
		return new Address(addressModel.getAddressId(),
				streetCtrl.toEntity(addressModel.getStreetid()),
				addressModel.getNumber());
	
	};

}
