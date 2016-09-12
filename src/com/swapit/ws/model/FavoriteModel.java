package com.swapit.ws.model;

import java.io.Serializable;

public class FavoriteModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String personId;
	private String propositionId;

	public FavoriteModel() {
	}
	

	public FavoriteModel(String personId, String propositionId) {
		super();
		this.personId = personId;
		this.propositionId = propositionId;
	}


	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPropositionId() {
		return this.propositionId;
	}

	public void setPropositionId(String propositionId) {
		this.propositionId = propositionId;
	}
	
	@Override
	public String toString() {
		return "Favorite [personId=" + personId + ", propositionId=" + propositionId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((propositionId == null) ? 0 : propositionId.hashCode());
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
		FavoriteModel other = (FavoriteModel) obj;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (propositionId == null) {
			if (other.propositionId != null)
				return false;
		} else if (!propositionId.equals(other.propositionId))
			return false;
		return true;
	}

}