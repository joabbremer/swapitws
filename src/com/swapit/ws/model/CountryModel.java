package com.swapit.ws.model;


public class CountryModel {
	
	private String countryId;	
	private String acronym;	
	private String name;
	
	public CountryModel() {
		super();
	}
	
	public CountryModel(String country, String acronym, String name) {
		super();
		this.countryId = country;
		this.acronym = acronym;
		this.name = name;
	}
	public String getCountry() {
		return countryId;
	}
	public void setCountryid(String country) {
		this.countryId = country;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CountryModel [countryid=" + countryId + ", acronym=" + acronym + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acronym == null) ? 0 : acronym.hashCode());
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
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
		CountryModel other = (CountryModel) obj;
		if (acronym == null) {
			if (other.acronym != null)
				return false;
		} else if (!acronym.equals(other.acronym))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
