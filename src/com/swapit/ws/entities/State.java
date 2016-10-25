package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="state")
@NamedQueries({
	@NamedQuery(name="findAllState", query="SELECT s FROM com.swapit.ws.entities.State s"),
	
})
public class State {
	
	@Id
	@Column(name="stateid", unique=true, nullable=false, length=36)
	private String stateid;
	
	@Column(length=2, name="acronym")
	private String acronym;
	
	@Column(length=255, name="name")
	private String name;
	
	@OneToOne(cascade = ALL, orphanRemoval = true, fetch = EAGER)
	@JoinColumn(name = "countryid")
	private Country country;

	public State() {
		super();
	}

	public State(String stateid, String acronym, String name, Country country) {
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

	public Country getCountry() {
		return country;
	}

	public void setCountryid(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [stateid=" + stateid + ", acronym=" + acronym + ", name=" + name + ", countryid=" + country
				+ "]";
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
		State other = (State) obj;
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
