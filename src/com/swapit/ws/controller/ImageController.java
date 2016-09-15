package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.entities.Image;
import com.swapit.ws.model.ImageModel;

public class ImageController {
	
	public List<ImageModel> toModel(List<Image> imageEntity){
		List<ImageModel> imgModel = new ArrayList<ImageModel>();
		for (Image image : imageEntity) {
			imgModel.add(new ImageModel(image.getImageId()));
			
		}
		
		return imgModel;
	};

}
