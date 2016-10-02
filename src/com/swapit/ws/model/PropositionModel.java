package com.swapit.ws.model;

import java.util.Date;
import java.util.List;



public class PropositionModel  {
	
	private String propositionId;	
	private String title;	
	private String description;	
	private AddressModel addressId;	
	private double price;	
	private double priceCatInterest;	
	private double totalPrice;	
	private List<CategoryModel> categoryId;	
	private String interest_category;	
	private List<PersonModel> personId;	
	private List<PropositionImageModel> imageId;	
	private Date publish_date;	
	private Date removel_date;
	
	public PropositionModel() {
		super();
	}

	public PropositionModel(String propositionId, String title, String description, AddressModel addressId,
			double price, double priceCatInterest, double totalPrice, List<CategoryModel> categoryId,
			String interest_category, List<PersonModel> personId, List<PropositionImageModel> imageId,
			Date publish_date, Date removel_date) {
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

	public AddressModel getAddressId() {
		return addressId;
	}

	public void setAddressId(AddressModel addressId) {
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

	public List<CategoryModel> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<CategoryModel> categoryId) {
		this.categoryId = categoryId;
	}

	public String getInterest_category() {
		return interest_category;
	}

	public void setInterest_category(String interest_category) {
		this.interest_category = interest_category;
	}

	public List<PersonModel> getPersonId() {
		return personId;
	}

	public void setPersonId(List<PersonModel> personId) {
		this.personId = personId;
	}

	public List<PropositionImageModel> getImageId() {
		return imageId;
	}

	public void setImageId(List<PropositionImageModel> imageId) {
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
		return "PropositionModel [propositionId=" + propositionId + ", title=" + title + ", description=" + description
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
		PropositionModel other = (PropositionModel) obj;
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