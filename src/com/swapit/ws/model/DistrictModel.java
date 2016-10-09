package com.swapit.ws.model;


public class DistrictModel {
	
	private String districtid;	
	private String name;	
	private CityModel city;
	
	public DistrictModel() {
		super();
	}
	public DistrictModel(String districtid, String name, CityModel city) {
		super();
		this.districtid = districtid;
		this.name = name;
		this.city = city;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CityModel getCity() {
		return city;
	}
	public void setCityid(CityModel city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "DistrictModel [districtid=" + districtid + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtid == null) ? 0 : districtid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DistrictModel other = (DistrictModel) obj;
		if (districtid == null) {
			if (other.districtid != null)
				return false;
		} else if (!districtid.equals(other.districtid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
