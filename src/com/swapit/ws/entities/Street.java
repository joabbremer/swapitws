package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.JoinColumn;

@Entity
@Table(name="street")
public class Street {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="streetid", unique=true, nullable=false, length=36)
	private String streetid;
	
	@OneToOne(orphanRemoval = true, fetch = EAGER, cascade = ALL)
	@JoinColumn(name = "streettypeid", referencedColumnName = "streettypeid")
	private StreetType streettypeid;
	
	@Column(length=100, name="name")
	private String name;
	
	@Column(length=100, name="complement")
	private String complement;
	
	@OneToOne(orphanRemoval = true, fetch = EAGER, cascade = ALL)
	@JoinColumn(name = "districtid", referencedColumnName = "districtid")
	private District districtid;
	
	@Column(length=9, name="zipcode")
	private char zipcode;

	public Street() {
		super();
	}

	public Street(String streetid, StreetType streettypeid, String name, String complement, District districtid,
			char zipcode) {
		super();
		this.streetid = streetid;
		this.streettypeid = streettypeid;
		this.name = name;
		this.complement = complement;
		this.districtid = districtid;
		this.zipcode = zipcode;
	}

	public String getStreetid() {
		return streetid;
	}

	public void setStreetid(String streetid) {
		this.streetid = streetid;
	}

	public StreetType getStreettypeid() {
		return streettypeid;
	}

	public void setStreettypeid(StreetType streettypeid) {
		this.streettypeid = streettypeid;
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

	public District getDistrictid() {
		return districtid;
	}

	public void setDistrictid(District districtid) {
		this.districtid = districtid;
	}

	public char getZipcode() {
		return zipcode;
	}

	public void setZipcode(char zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Street [streetid=" + streetid + ", streettypeid=" + streettypeid + ", name=" + name + ", complement="
				+ complement + ", districtid=" + districtid + ", zipcode=" + zipcode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complement == null) ? 0 : complement.hashCode());
		result = prime * result + ((districtid == null) ? 0 : districtid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((streetid == null) ? 0 : streetid.hashCode());
		result = prime * result + ((streettypeid == null) ? 0 : streettypeid.hashCode());
		result = prime * result + zipcode;
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
		Street other = (Street) obj;
		if (complement == null) {
			if (other.complement != null)
				return false;
		} else if (!complement.equals(other.complement))
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
		if (streetid == null) {
			if (other.streetid != null)
				return false;
		} else if (!streetid.equals(other.streetid))
			return false;
		if (streettypeid == null) {
			if (other.streettypeid != null)
				return false;
		} else if (!streettypeid.equals(other.streettypeid))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}
	
	

}
