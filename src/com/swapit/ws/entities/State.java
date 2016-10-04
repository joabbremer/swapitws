package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@Column(name="stateid", unique=true, nullable=false, length=36)
	private String stateid;
	
	@Column(length=2, name="acronym")
	private char acronym;
	
	@Column(length=255, name="name")
	private String name;
	
	@OneToOne(cascade = ALL, orphanRemoval = true, fetch = EAGER)
	@JoinColumn(name = "countryid")
	private Country countryid;

	public State() {
		super();
	}

	public State(String stateid, char acronym, String name, Country countryid) {
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

	public Country getCountryid() {
		return countryid;
	}

	public void setCountryid(Country countryid) {
		this.countryid = countryid;
	}

	@Override
	public String toString() {
		return "State [stateid=" + stateid + ", acronym=" + acronym + ", name=" + name + ", countryid=" + countryid
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acronym;
		result = prime * result + ((countryid == null) ? 0 : countryid.hashCode());
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
		State other = (State) obj;
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
		if (stateid == null) {
			if (other.stateid != null)
				return false;
		} else if (!stateid.equals(other.stateid))
			return false;
		return true;
	}

	
	
}
