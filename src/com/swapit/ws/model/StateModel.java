package com.swapit.ws.model;



public class StateModel {
	
	private String stateid;	
	private char acronym;	
	private String name;	
	private CountryModel countryid;
	public StateModel() {
		super();
	}
	public StateModel(String stateid, char acronym, String name, CountryModel countryid) {
		super();
		this.stateid = stateid;
		this.acronym = acronym;
		this.name = name;
		this.countryid = countryid;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	public char getAcronym() {
		return acronym;
	}
	public void setAcronym(char acronym) {
		this.acronym = acronym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CountryModel getCountryid() {
		return countryid;
	}
	public void setCountryid(CountryModel countryid) {
		this.countryid = countryid;
	}
	@Override
	public String toString() {
		return "StateModel [stateid=" + stateid + ", acronym=" + acronym + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acronym;
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
		if (acronym != other.acronym)
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
