package com.swapit.ws.model;

import java.io.Serializable;



public class ImageModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String image_id;

	public ImageModel() {
		super();
	}
	
	public ImageModel(String imageId) {
		super();
		this.image_id = imageId;
	}

	public String getImageId() {
		return image_id;
	}

	public void setImageId(String imageId) {
		this.image_id = imageId;
	}

	



}