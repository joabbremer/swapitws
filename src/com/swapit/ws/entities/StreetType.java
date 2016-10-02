package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="streettype")
public class StreetType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="streettypeid", unique=true, nullable=false, length=36)
	private String streettypeid;
	
	@Column(length=100, name="name")
	private String name;

	public StreetType() {
		super();
	}

	public StreetType(String streettypeid, String name) {
		super();
		this.streettypeid = streettypeid;
		this.name = name;
	}

	public String getStreettypeid() {
		return streettypeid;
	}

	public void setStreettypeid(String streettypeid) {
		this.streettypeid = streettypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StreetType [streettypeid=" + streettypeid + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((streettypeid == null) ? 0 : streettypeid.hashCode());
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
		StreetType other = (StreetType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (streettypeid == null) {
			if (other.streettypeid != null)
				return false;
		} else if (!streettypeid.equals(other.streettypeid))
			return false;
		return true;
	}
	
	

}
