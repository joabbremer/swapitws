package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;

@Entity
@Table(name="city")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cityid", unique=true, nullable=false, length=36)
	private String cityid;
	
	@Column(length=255, name="name")
	private String name;
	
	@Column(length=9, name="zipcode")
	private String zipcode;
	
	@OneToOne(cascade = ALL, fetch = EAGER, orphanRemoval = true)
	@JoinColumn(name = "stateid", referencedColumnName = "stateid")
	private State stateid;

	public City() {
		super();
	}

	public City(String cityid, String name, String zipcode, State stateid) {
		super();
		this.cityid = cityid;
		this.name = name;
		this.zipcode = zipcode;
		this.stateid = stateid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public State getStateid() {
		return stateid;
	}

	public void setStateid(State stateid) {
		this.stateid = stateid;
	}

	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", name=" + name + ", zipcode=" + zipcode + ", stateid=" + stateid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityid == null) ? 0 : cityid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stateid == null) ? 0 : stateid.hashCode());
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
		City other = (City) obj;
		if (cityid == null) {
			if (other.cityid != null)
				return false;
		} else if (!cityid.equals(other.cityid))
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
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	
	
	
}
