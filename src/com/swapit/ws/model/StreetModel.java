package com.swapit.ws.model;


public class StreetModel {
	
	private String streetid;
	private StreetTypeModel streettype;	
	private String name;
	private String complement;	
	private DistrictModel district;
	private String zipcode;
	
	public StreetModel() {
		super();
	}
	public StreetModel(String streetid, StreetTypeModel streettype, String name, String complement,
			DistrictModel district, String zipcode) {
		super();
		this.streetid = streetid;
		this.streettype = streettype;
		this.name = name;
		this.complement = complement;
		this.district = district;
		this.zipcode = zipcode;
	}
	public String getStreetid() {
		return streetid;
	}
	public void setStreetid(String streetid) {
		this.streetid = streetid;
	}
	public StreetTypeModel getStreettype() {
		return streettype;
	}
	public void setStreettypeid(StreetTypeModel streettype) {
		this.streettype = streettype;
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
	public DistrictModel getDistrict() {
		return district;
	}
	public void setDistrict(DistrictModel district) {
		this.district = district;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "StreetModel [streetid=" + streetid + ", streettypeid=" + streettype + ", name=" + name
				+ ", complement=" + complement + ", zipcode=" + zipcode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complement == null) ? 0 : complement.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((streetid == null) ? 0 : streetid.hashCode());
		result = prime * result + ((streettype == null) ? 0 : streettype.hashCode());
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
		StreetModel other = (StreetModel) obj;
		if (complement == null) {
			if (other.complement != null)
				return false;
		} else if (!complement.equals(other.complement))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
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
		if (streettype == null) {
			if (other.streettype != null)
				return false;
		} else if (!streettype.equals(other.streettype))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	
}
