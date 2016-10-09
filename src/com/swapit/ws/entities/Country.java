package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@Column(name="countryid", unique=true, nullable=false, length=36)
	private String countryid;
	
	@Column(length=2, name="acronym")
	private char acronym;
	
	@Column(length=45, name="name")
	private String name;

	public Country() {
		super();
	}

	public Country(String countryid, char acronym, String name) {
		super();
		this.countryid = countryid;
		this.acronym = acronym;
		this.name = name;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
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

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", acronym=" + acronym + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acronym;
		result = prime * result + ((countryid == null) ? 0 : countryid.hashCode());
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
		Country other = (Country) obj;
		if (acronym != other.acronym)
			return false;
		if (countryid == null) {
			if (other.countryid != null)
				return false;
		} else if (!countryid.equals(other.countryid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
