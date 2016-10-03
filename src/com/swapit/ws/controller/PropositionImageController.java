package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.entities.PropositionImage;
import com.swapit.ws.model.PropositionImageModel;

public class PropositionImageController {

	public List<PropositionImage> toEntity(List<PropositionImageModel> imageId) {
		List<PropositionImage> propImg = new ArrayList<PropositionImage>();
		for (PropositionImageModel propositionImageModel : imageId) {
			propImg.add(new PropositionImage(propositionImageModel.getImageid()));
			
		}
		return propImg;
	}

	public List<PropositionImageModel> toModel(List<PropositionImage> imageId) {
		List<PropositionImageModel> propImgModel = new ArrayList<PropositionImageModel>();
		for (PropositionImage propositionImage : imageId) {
			propImgModel.add(new PropositionImageModel(propositionImage.getImageid()));
		}
		return propImgModel;
	}

}
