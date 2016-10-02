package com.swapit.ws.model;

public class PropositionImageModel {
	
	private String imageid;

	public PropositionImageModel() {
		super();
	}

	public PropositionImageModel(String imageid) {
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
		return "PropositionImageModel [imageid=" + imageid + "]";
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
		PropositionImageModel other = (PropositionImageModel) obj;
		if (imageid == null) {
			if (other.imageid != null)
				return false;
		} else if (!imageid.equals(other.imageid))
			return false;
		return true;
	}
	

}
