package com.swapit.ws.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIMESTAMP;


@Entity
@Table(name="proposition")
@NamedQuery(name="Proposition.findAll", query="SELECT p FROM Proposition p")

public class Proposition implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="propositionid", unique=true, nullable=false, length=36)
	private String propositionId;
	
	@Column(length=50, name="title")
	private String title;
	
	@Column(length=200, name="description")
	private String description;
	
	@OneToOne(orphanRemoval = true, cascade = ALL, fetch = EAGER)
	@JoinColumn(name = "addressid", referencedColumnName = "addressid")
	private Address addressId;
	
	@Column(name="price")
	private double price;
	
	@Column(name="price_cat_interest")
	private double priceCatInterest;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@OneToMany( fetch = EAGER, cascade = ALL)
	@JoinColumn(name = "categoryid")
	private List<Category> categoryId;
	
	@Column(name="interest_category", length=36)
	private String interest_category;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "personid", referencedColumnName = "personid", nullable=true)
	private Person personId;
	

	@OneToMany(cascade = ALL)
	@JoinColumn(name = "imageid")
	private List<PropositionImage> imageId;
	
	@Column(name="publish_date")
	@Temporal(DATE)
	private Date publish_date;
	
	@Column(name="removel_date")
	@Temporal(TIMESTAMP)
	private Date removel_date;
	
	

	public Proposition() {
		super();
	}

	public Proposition(String propositionId, String title, String description, Address addressId, double price,
			double priceCatInterest, double totalPrice, List<Category> categoryId, String interest_category,
			Person personId, List<PropositionImage> imageId, Date publish_date, Date removel_date) {
		super();
		this.propositionId = propositionId;
		this.title = title;
		this.description = description;
		this.addressId = addressId;
		this.price = price;
		this.priceCatInterest = priceCatInterest;
		this.totalPrice = totalPrice;
		this.categoryId = categoryId;
		this.interest_category = interest_category;
		this.personId = personId;
		this.imageId = imageId;
		this.publish_date = publish_date;
		this.removel_date = removel_date;
	}

	public String getPropositionId() {
		return propositionId;
	}

	public void setPropositionId(String propositionId) {
		this.propositionId = propositionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceCatInterest() {
		return priceCatInterest;
	}

	public void setPriceCatInterest(double priceCatInterest) {
		this.priceCatInterest = priceCatInterest;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Category> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Category> categoryId) {
		this.categoryId = categoryId;
	}

	public String getInterest_category() {
		return interest_category;
	}

	public void setInterest_category(String interest_category) {
		this.interest_category = interest_category;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	public List<PropositionImage> getImageId() {
		return imageId;
	}

	public void setImageId(List<PropositionImage> imageId) {
		this.imageId = imageId;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public Date getRemovel_date() {
		return removel_date;
	}

	public void setRemovel_date(Date removel_date) {
		this.removel_date = removel_date;
	}

	@Override
	public String toString() {
		return "Proposition [propositionId=" + propositionId + ", title=" + title + ", description=" + description
				+ ", addressId=" + addressId + ", price=" + price + ", priceCatInterest=" + priceCatInterest
				+ ", totalPrice=" + totalPrice + ", categoryId=" + categoryId + ", interest_category="
				+ interest_category + ", personId=" + personId + ", imageId=" + imageId + ", publish_date="
				+ publish_date + ", removel_date=" + removel_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
		result = prime * result + ((interest_category == null) ? 0 : interest_category.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceCatInterest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((propositionId == null) ? 0 : propositionId.hashCode());
		result = prime * result + ((publish_date == null) ? 0 : publish_date.hashCode());
		result = prime * result + ((removel_date == null) ? 0 : removel_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Proposition other = (Proposition) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageId == null) {
			if (other.imageId != null)
				return false;
		} else if (!imageId.equals(other.imageId))
			return false;
		if (interest_category == null) {
			if (other.interest_category != null)
				return false;
		} else if (!interest_category.equals(other.interest_category))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(priceCatInterest) != Double.doubleToLongBits(other.priceCatInterest))
			return false;
		if (propositionId == null) {
			if (other.propositionId != null)
				return false;
		} else if (!propositionId.equals(other.propositionId))
			return false;
		if (publish_date == null) {
			if (other.publish_date != null)
				return false;
		} else if (!publish_date.equals(other.publish_date))
			return false;
		if (removel_date == null) {
			if (other.removel_date != null)
				return false;
		} else if (!removel_date.equals(other.removel_date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}
	
	
	
	



}