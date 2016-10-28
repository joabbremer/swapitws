package com.swapit.ws.model.reduce;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swapit.ws.model.CategoryModel;
import com.swapit.ws.model.PropositionImageModel;

public class PropositionReduce {
	
	private String propositionId;	
	private String title;	
	private String description;	
	private AddressReduce addressReduce;	
	private double price;	
	private double priceCatInterest;	
	private double totalPrice;	
	private CategoryModel category;	
	private String interest_category;	
	private PersonReduce personReduce;	
	private List<PropositionImageModel> image;	
	private Date publish_date;	
	private Date removel_date;
	
	public PropositionReduce() {
		super();
	}

	public PropositionReduce(String propositionId, String title, String description, AddressReduce addressReduce,
			double price, double priceCatInterest, double totalPrice, CategoryModel category,
			String interest_category, PersonReduce personReduce, List<PropositionImageModel> image, Date publish_date,
			Date removel_date) {
		super();
		this.propositionId = propositionId;
		this.title = title;
		this.description = description;
		this.addressReduce = addressReduce;
		this.price = price;
		this.priceCatInterest = priceCatInterest;
		this.totalPrice = totalPrice;
		this.category = category;
		this.interest_category = interest_category;
		this.personReduce = personReduce;
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

	public AddressReduce getAddressReduce() {
		return addressReduce;
	}

	public void setAddressReduce(AddressReduce addressReduce) {
		this.addressReduce = addressReduce;
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

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public String getInterest_category() {
		return interest_category;
	}

	public void setInterest_category(String interest_category) {
		this.interest_category = interest_category;
	}

	public PersonReduce getPersonReduce() {
		return personReduce;
	}

	public void setPersonReduce(PersonReduce personReduce) {
		this.personReduce = personReduce;
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
		return "PropositionReduce [propositionId=" + propositionId + ", title=" + title + ", description=" + description
				+ ", addressReduce=" + addressReduce + ", price=" + price + ", priceCatInterest=" + priceCatInterest
				+ ", totalPrice=" + totalPrice + ", category=" + category + ", interest_category=" + interest_category
				+ ", person=" + personReduce + ", image=" + image + ", publish_date=" + publish_date + ", removel_date="
				+ removel_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressReduce == null) ? 0 : addressReduce.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((interest_category == null) ? 0 : interest_category.hashCode());
		result = prime * result + ((personReduce == null) ? 0 : personReduce.hashCode());
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
		PropositionReduce other = (PropositionReduce) obj;
		if (addressReduce == null) {
			if (other.addressReduce != null)
				return false;
		} else if (!addressReduce.equals(other.addressReduce))
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
		if (personReduce == null) {
			if (other.personReduce != null)
				return false;
		} else if (!personReduce.equals(other.personReduce))
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
