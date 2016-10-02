package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;

@Entity
@Table(name="district")
public class District {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="districtid", unique=true, nullable=false, length=36)
	private String districtid;
	
	@Column(length=100, name="name")
	private String name;
	
	@OneToOne(orphanRemoval = true, cascade = ALL, fetch = EAGER)
	@JoinColumn(name = "cityid", referencedColumnName = "cityid")
	private City cityid;

	public District() {
		super();
	}

	public District(String districtid, String name, City cityid) {
		super();
		this.districtid = districtid;
		this.name = name;
		this.cityid = cityid;
	}

	public String getDistrictid() {
		return districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCityid() {
		return cityid;
	}

	public void setCityid(City cityid) {
		this.cityid = cityid;
	}

	@Override
	public String toString() {
		return "District [districtid=" + districtid + ", name=" + name + ", cityid=" + cityid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityid == null) ? 0 : cityid.hashCode());
		result = prime * result + ((districtid == null) ? 0 : districtid.hashCode());
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
		District other = (District) obj;
		if (cityid == null) {
			if (other.cityid != null)
				return false;
		} else if (!cityid.equals(other.cityid))
			return false;
		if (districtid == null) {
			if (other.districtid != null)
				return false;
		} else if (!districtid.equals(other.districtid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
