package com.swapit.ws.controller;

import com.swapit.ws.entities.StreetType;
import com.swapit.ws.model.StreetTypeModel;

public class StreetTypeController {

	public StreetType toEntity(StreetTypeModel streetTypeModel) {
		return new StreetType(streetTypeModel.getStreettypeid(),
						streetTypeModel.getName());
	}

	public StreetTypeModel toModel(StreetType streetType) {
		return new StreetTypeModel(streetType.getStreettypeid(),
							streetType.getName());
	}

}
