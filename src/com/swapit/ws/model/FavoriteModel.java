package com.swapit.ws.model;

public class FavoriteModel {
	
	private String favoriteid;
	private String personid;
	private String propositionid;

	public FavoriteModel() {
		super();
	}

	public FavoriteModel(String favoriteid, String personid, String propositionid) {
		super();
		this.favoriteid = favoriteid;
		this.personid = personid;
		this.propositionid = propositionid;
	}


	public FavoriteModel(String personid, String propositionid) {
		super();
		this.personid = personid;
		this.propositionid = propositionid;
	}

	public String getFavoriteid() {
		return favoriteid;
	}

	public void setFavoriteid(String favoriteid) {
		this.favoriteid = favoriteid;
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
	
	
	
	

}
