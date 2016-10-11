package com.swapit.ws.reduce;

public class AddressReduce {

	private String streetid;
	private String zipcode; //dentro de street
	private String streetName; // streettype + street
	private String complement; //Street
	private String number; //address
	private String districtName; //dsitrict
	private String cityName;	//city
	private String stateAcronym; //state
	private String stateName; //state
	private String countryAcronym;  //country
	private String countryName;  //country
	
	public AddressReduce() {
		super();
	}


	public AddressReduce(String streetid, String zipcode, String streetName, String complement, String number,
			String districtName, String cityName, String stateAcronym, String stateName, String countryAcronym,
			String countryName) {
		super();
		this.streetid = streetid;
		this.zipcode = zipcode;
		this.streetName = streetName;
		this.complement = complement;
		this.number = number;
		this.districtName = districtName;
		this.cityName = cityName;
		this.stateAcronym = stateAcronym;
		this.stateName = stateName;
		this.countryAcronym = countryAcronym;
		this.countryName = countryName;
	}


	public String getStreetid() {
		return streetid;
	}


	public void setStreetid(String streetid) {
		this.streetid = streetid;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateAcronym() {
		return stateAcronym;
	}

	public void setStateAcronym(String stateAcronym) {
		this.stateAcronym = stateAcronym;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryAcronym() {
		return countryAcronym;
	}

	public void setCountryAcronym(String countryAcronym) {
		this.countryAcronym = countryAcronym;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((complement == null) ? 0 : complement.hashCode());
		result = prime * result + ((countryAcronym == null) ? 0 : countryAcronym.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
		result = prime * result + ((stateAcronym == null) ? 0 : stateAcronym.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
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
		AddressReduce other = (AddressReduce) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (complement == null) {
			if (other.complement != null)
				return false;
		} else if (!complement.equals(other.complement))
			return false;
		if (countryAcronym == null) {
			if (other.countryAcronym != null)
				return false;
		} else if (!countryAcronym.equals(other.countryAcronym))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		if (stateAcronym == null) {
			if (other.stateAcronym != null)
				return false;
		} else if (!stateAcronym.equals(other.stateAcronym))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	
	
	
	
	
	
}
