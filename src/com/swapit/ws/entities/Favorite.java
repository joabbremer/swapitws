package com.swapit.ws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
public class Favorite {
	
	@Id
	@Column(name="favoriteid", unique=true, nullable=true, length=36)
	private String favoriteid;
	
	@Column(length=36, name="personid", nullable=true)
	private String personid;
	
	@Column(length=36, name="propositionid", nullable=true)
	private String propositionid;
	
	public Favorite() {
		super();
	}

	public Favorite(String favoriteid, String personid, String propositionid) {
		super();
		this.favoriteid = favoriteid;
		this.personid = personid;
		this.propositionid = propositionid;
	}
	
	public Favorite(String personid, String propositionid) {
		super();
		this.personid = personid;
		this.propositionid = propositionid;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getPropositionid() {
		return propositionid;
	}

	public void setPropositionid(String propositionid) {
		this.propositionid = propositionid;
	}

	public String getFavoriteid() {
		return favoriteid;
	}

	public void setFavoriteid(String favoriteid) {
		this.favoriteid = favoriteid;
	}
	
	
	
	
	

}
