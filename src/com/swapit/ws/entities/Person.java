package com.swapit.ws.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinTable;

@Entity
@NamedQueries({
	@NamedQuery(name="findAllPersons", query="SELECT p FROM Person p"),
	@NamedQuery(name="selectIDPerson", query = "SELECT P FROM Person p WHERE p.personId = :personId"),
	@NamedQuery(name="loginPerson", query = "SELECT P FROM Person p WHERE p.email = :email AND p.password = :password"),
	@NamedQuery(name="findPersonEmail", query = "SELECT P FROM Person p WHERE p.email = :email"),
})



public class Person {
	
	@Id
	@Column(name="personid", unique=true, nullable=false, length=36)
	private String personId;
	
	@Column(length=50, name="person_name", nullable=false)
	private String personName;
	
	@Column(length=50, name="email", nullable=true)
	private String email;
	
	@Column(length=12, name="phone", nullable=true)
	private String phone;
	
	@Column(length=50, name="password", nullable=false)
	private String password;
	
	@Column(length=1, name="sex", nullable=true)
	private char sex;
	
	@Column(length=11, name="blocked", nullable=true)
	private int blocked;
	
	@Column(length=10, name="level", nullable=true)
	private String level;
	
	@OneToMany(cascade = ALL, fetch = EAGER)
	@JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "personid", referencedColumnName = "personid", nullable=true), inverseJoinColumns = @JoinColumn(name = "propositionid", referencedColumnName = "propositionid", nullable=true))
	private List<Proposition> favorite;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "addressid", referencedColumnName = "addressid", nullable=true)
	private Address address;

	public Person() {
		super();
	}
	


	public Person(String personId, String personName, String email, String phone, String password, char sex,
			int blocked, String level) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.sex = sex;
		this.blocked = blocked;
		this.level = level;
	}



	public Person(String personId, String personName, String email, String phone, String password, char sex,
			int blocked, String level, List<Proposition> favorite, Address address) {
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
		this.address = address;
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

	public List<Proposition> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<Proposition> favorite) {
		this.favorite = favorite;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddresid(Address addresid) {
		this.address = addresid;
	}
	
	
	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", sex=" + sex + ", blocked=" + blocked + ", favorite=" + favorite
				+ ", addresid=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + blocked;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favorite == null) ? 0 : favorite.hashCode());
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
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
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
