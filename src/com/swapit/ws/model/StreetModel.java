package com.swapit.ws.model;


public class StreetModel {
	
	private String streetid;
	private StreetTypeModel streettypeid;	
	private String name;
	private String complement;	
	private DistrictModel districtid;
	private char zipcode;
	
	public StreetModel() {
		super();
	}
	public StreetModel(String streetid, StreetTypeModel streettypeid, String name, String complement,
			DistrictModel districtid, char zipcode) {
		super();
		this.streetid = streetid;
		this.streettypeid = streettypeid;
		this.name = name;
		this.complement = complement;
		this.districtid = districtid;
		this.zipcode = zipcode;
	}
	public String getStreetid() {
		return streetid;
	}
	public void setStreetid(String streetid) {
		this.streetid = streetid;
	}
	public StreetTypeModel getStreettypeid() {
		return streettypeid;
	}
	public void setStreettypeid(StreetTypeModel streettypeid) {
		this.streettypeid = streettypeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public DistrictModel getDistrictid() {
		return districtid;
	}
	public void setDistrictid(DistrictModel districtid) {
		this.districtid = districtid;
	}
	public char getZipcode() {
		return zipcode;
	}
	public void setZipcode(char zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "StreetModel [streetid=" + streetid + ", streettypeid=" + streettypeid + ", name=" + name
				+ ", complement=" + complement + ", zipcode=" + zipcode + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complement == null) ? 0 : complement.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((streetid == null) ? 0 : streetid.hashCode());
		result = prime * result + ((streettypeid == null) ? 0 : streettypeid.hashCode());
		result = prime * result + zipcode;
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
		StreetModel other = (StreetModel) obj;
		if (complement == null) {
			if (other.complement != null)
				return false;
		} else if (!complement.equals(other.complement))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (streetid == null) {
			if (other.streetid != null)
				return false;
		} else if (!streetid.equals(other.streetid))
			return false;
		if (streettypeid == null) {
			if (other.streettypeid != null)
				return false;
		} else if (!streettypeid.equals(other.streettypeid))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}

	
}
