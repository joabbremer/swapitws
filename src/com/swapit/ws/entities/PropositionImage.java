package com.swapit.ws.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proposition_image")
public class PropositionImage {
	
	@Id
	@Column(name="imageid", unique=true, nullable=false, length=36)
	private String imageid;

	public PropositionImage() {
		super();
	}

	public PropositionImage(String imageid) {
		super();
		this.imageid = imageid;
	}

	public String getImageid() {
		return imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	@Override
	public String toString() {
		return "PropositionImage [imageid=" + imageid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageid == null) ? 0 : imageid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropositionImage other = (PropositionImage) obj;
		if (imageid == null) {
			if (other.imageid != null)
				return false;
		} else if (!imageid.equals(other.imageid))
			return false;
		return true;
	}
	
	

	
	
}
