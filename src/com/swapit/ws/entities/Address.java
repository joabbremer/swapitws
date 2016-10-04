package com.swapit.ws.entities;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="addressid", unique=true, nullable=false, length=36)
	private String addressId;
	
	
	@OneToOne(orphanRemoval = true, cascade = ALL, fetch = EAGER)
	@JoinColumn(name = "streetid", referencedColumnName = "streetid")
	private Street streetid;
	
	@Column(length=15, name="number")
	private String number;

	public Address() {
		super();
	}

	public Address(String addressId, Street streetid, String number) {
		super();
		this.addressId = addressId;
		this.streetid = streetid;
		this.number = number;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Street getStreetid() {
		return streetid;
	}

	public void setStreetid(Street streetid) {
		this.streetid = streetid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetid=" + streetid + ", number=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((streetid == null) ? 0 : streetid.hashCode());
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
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (streetid == null) {
			if (other.streetid != null)
				return false;
		} else if (!streetid.equals(other.streetid))
			return false;
		return true;
	}
	
	

	
}