package com.swapit.ws.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="image")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="image_id", unique=true, nullable=false, length=36)
	private String image_id;

	public Image() {
		super();
	}
	
	public Image(String imageId) {
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