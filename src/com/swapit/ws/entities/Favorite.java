package com.swapit.ws.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="favorite")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id", unique=true, nullable=false, length=36)
	private String personId;

	@Column(name="proposition_id", nullable=false, length=36)
	private String propositionId;

	public Favorite() {
	}
	

	public Favorite(String personId, String propositionId) {
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
		Favorite other = (Favorite) obj;
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