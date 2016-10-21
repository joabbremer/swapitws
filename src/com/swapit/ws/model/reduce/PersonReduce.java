package com.swapit.ws.model.reduce;

import java.util.List;
import com.swapit.ws.model.PropositionModel;



public class PersonReduce {

	private String personId;	
	private String personName;	
	private String email;	
	private String phone;	
	private String password;	
	private char sex;	
	private int blocked;
	private String level;
	private List<PropositionModel> favorite;	
	private AddressReduce addressReduce;
	
	public PersonReduce() {
		super();
	}

	public PersonReduce(String personId, String personName, String email, String phone, String password, char sex,
			int blocked, String level, List<PropositionModel> favorite, AddressReduce addressReduce) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.sex = sex;
		this.blocked = blocked;
		this.level = level;
		this.favorite = favorite;
		this.addressReduce = addressReduce;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<PropositionModel> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<PropositionModel> favorite) {
		this.favorite = favorite;
	}

	public AddressReduce getAddressReduce() {
		return addressReduce;
	}

	public void setAddressReduce(AddressReduce addressReduce) {
		this.addressReduce = addressReduce;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressReduce == null) ? 0 : addressReduce.hashCode());
		result = prime * result + blocked;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favorite == null) ? 0 : favorite.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + sex;
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
		PersonReduce other = (PersonReduce) obj;
		if (addressReduce == null) {
			if (other.addressReduce != null)
				return false;
		} else if (!addressReduce.equals(other.addressReduce))
			return false;
		if (blocked != other.blocked)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favorite == null) {
			if (other.favorite != null)
				return false;
		} else if (!favorite.equals(other.favorite))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	
	
	
	
	
}
