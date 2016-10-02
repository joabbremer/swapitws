package com.swapit.ws.model;




public class AddressModel{	
	
	private String addressId;
	private StreetModel streetid;	
	private String number;
	
	public AddressModel() {
		super();
	}
	public AddressModel(String addressId, StreetModel streetid, String number) {
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
	public StreetModel getStreetid() {
		return streetid;
	}
	public void setStreetid(StreetModel streetid) {
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
		return "AddressModel [addressId=" + addressId + ", streetid=" + streetid + ", number=" + number + "]";
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
		AddressModel other = (AddressModel) obj;
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