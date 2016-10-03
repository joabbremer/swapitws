package com.swapit.ws.controller;

import com.swapit.ws.entities.Street;
import com.swapit.ws.model.StreetModel;

public class StreetController {

	public Street toEntity(StreetModel streetModel) {
		StreetTypeController StrTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		return new Street(streetModel.getStreetid(),
					StrTypeCtrl.toEntity(streetModel.getStreettypeid()),
					streetModel.getName(),
					streetModel.getComplement(),
					districtCtrl.toEntity(streetModel.getDistrictid()),
					streetModel.getZipcode());
		 
	}

	public StreetModel toModel(Street streetEntity) {
		StreetTypeController StrTypeCtrl = new StreetTypeController();
		DistrictController districtCtrl = new DistrictController();
		return new StreetModel(streetEntity.getStreetid(),
						StrTypeCtrl.toModel(streetEntity.getStreettypeid()),
						streetEntity.getName(),
						streetEntity.getComplement(),
						districtCtrl.toModel(streetEntity.getDistrictid()),
						streetEntity.getZipcode());
		 
	}

}
