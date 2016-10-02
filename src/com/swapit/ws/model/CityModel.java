package com.swapit.ws.model;

public class CityModel {
	
	private String cityid;	
	private String name;	
	private String zipcode;	
	private StateModel stateid;
	
	public CityModel() {
		super();
	}

	public CityModel(String cityid, String name, String zipcode, StateModel stateid) {
		super();
		this.cityid = cityid;
		this.name = name;
		this.zipcode = zipcode;
		this.stateid = stateid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public StateModel getStateid() {
		return stateid;
	}

	public void setStateid(StateModel stateid) {
		this.stateid = stateid;
	}

	@Override
	public String toString() {
		return "CityModel [cityid=" + cityid + ", name=" + name + ", zipcode=" + zipcode + ", stateid=" + stateid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityid == null) ? 0 : cityid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stateid == null) ? 0 : stateid.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		CityModel other = (CityModel) obj;
		if (cityid == null) {
			if (other.cityid != null)
				return false;
		} else if (!cityid.equals(other.cityid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stateid == null) {
			if (other.stateid != null)
				return false;
		} else if (!stateid.equals(other.stateid))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	
	
	

}
