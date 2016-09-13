package com.swapit.ws.controller;


import com.swapit.ws.entities.Address;
import com.swapit.ws.model.AddressModel;

public class AddressController {
	
	public AddressModel toModel(Address addressEntity){		
		
			return new AddressModel(addressEntity.getAddressId(),
					addressEntity.getAddress(),
					addressEntity.getCity(),
					addressEntity.getComplement(),
					addressEntity.getNumber(),
					addressEntity.getState(),
					addressEntity.getZipCode());
		
	}
	
	public Address toEntity(AddressModel addressModel){
		return new Address(addressModel.getAddressId(),
				addressModel.getAddress(),
				addressModel.getCity(),
				addressModel.getComplement(),
				addressModel.getNumber(),
				addressModel.getState(),
				addressModel.getZipCode());
	
	};

}
