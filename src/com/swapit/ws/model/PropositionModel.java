package com.swapit.ws.model;

import java.util.Date;
import java.util.List;



public class PropositionModel  {
	
	private String propositionId;	
	private String title;	
	private String description;	
	private AddressModel address;	
	private double price;	
	private double priceCatInterest;	
	private double totalPrice;	
	private List<CategoryModel> category;	
	private String interest_category;	
	private PersonModel person;	
	private List<PropositionImageModel> image;	
	private Date publish_date;	
	private Date removel_date;
	
	public PropositionModel() {
		super();
	}

	public PropositionModel(String propositionId, String title, String description, AddressModel address,
			double price, double priceCatInterest, double totalPrice, List<CategoryModel> category,
			String interest_category, PersonModel person, List<PropositionImageModel> image,
			Date publish_date, Date removel_date) {
		super();
		this.propositionId = propositionId;
		this.title = title;
		this.description = description;
		this.address = address;
		this.price = price;
		this.priceCatInterest = priceCatInterest;
		this.totalPrice = totalPrice;
		this.category = category;
		this.interest_category = interest_category;
		this.person = person;
		this.image = image;
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

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
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

	public List<CategoryModel> getCategory() {
		return category;
	}

	public void setCategoryId(List<CategoryModel> category) {
		this.category = category;
	}

	public String getInterest_category() {
		return interest_category;
	}

	public void setInterest_category(String interest_category) {
		this.interest_category = interest_category;
	}

	public PersonModel getPersonId() {
		return person;
	}

	public void setPersonId(PersonModel personId) {
		this.person = personId;
	}

	public List<PropositionImageModel> getImage() {
		return image;
	}

	public void setImage(List<PropositionImageModel> image) {
		this.image = image;
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
		return "PropositionModel [propositionId=" + propositionId + ", title=" + title + ", description=" + description
				+ ", addressId=" + address + ", price=" + price + ", priceCatInterest=" + priceCatInterest
				+ ", totalPrice=" + totalPrice + ", categoryId=" + category + ", interest_category="
				+ interest_category + ", personId=" + person + ", imageId=" + image + ", publish_date="
				+ publish_date + ", removel_date=" + removel_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((interest_category == null) ? 0 : interest_category.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		PropositionModel other = (PropositionModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (interest_category == null) {
			if (other.interest_category != null)
				return false;
		} else if (!interest_category.equals(other.interest_category))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
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