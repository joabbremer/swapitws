package com.swapit.ws.model;



public class StateModel {
	
	private String stateid;	
	private String acronym;	
	private String name;	
	private CountryModel country;
	public StateModel() {
		super();
	}
	public StateModel(String stateid, String acronym, String name, CountryModel country) {
		super();
		this.stateid = stateid;
		this.acronym = acronym;
		this.name = name;
		this.country = country;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
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
	public CountryModel getCountry() {
		return country;
	}
	public void setCountry(CountryModel country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "StateModel [stateid=" + stateid + ", acronym=" + acronym + ", name=" + name + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acronym == null) ? 0 : acronym.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stateid == null) ? 0 : stateid.hashCode());
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
		StateModel other = (StateModel) obj;
		if (acronym == null) {
			if (other.acronym != null)
				return false;
		} else if (!acronym.equals(other.acronym))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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
		return true;
	}
	
	
	

}
