package com.swapit.ws.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class PropositionModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String propositionId;
	private String city;
	private String description;
	private String interestCategory;
	private BigDecimal price;
	private BigDecimal priceCatInterest;
	private String state;
	private String title;
	private BigDecimal totalPrice;
	private String zipCode;
	private Date publish_date;
	private List<ImageModel> image_id;
	private List<CategoryModel> prop_category;
	private List<PersonModel> personId;

	public PropositionModel() {
		super();
	}

	public PropositionModel(String propositionId, String city, String description, String interestCategory, BigDecimal price,
			BigDecimal priceCatInterest, String state, String title, BigDecimal totalPrice, String zipCode,
			Date publish_date, List<ImageModel> image_id, List<CategoryModel> prop_category, List<PersonModel> personId) {
		super();
		this.propositionId = propositionId;
		this.city = city;
		this.description = description;
		this.interestCategory = interestCategory;
		this.price = price;
		this.priceCatInterest = priceCatInterest;
		this.state = state;
		this.title = title;
		this.totalPrice = totalPrice;
		this.zipCode = zipCode;
		this.publish_date = publish_date;
		this.image_id = image_id;
		this.prop_category = prop_category;
		this.personId = personId;
	}

	public String getPropositionId() {
		return propositionId;
	}

	public void setPropositionId(String propositionId) {
		this.propositionId = propositionId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterestCategory() {
		return interestCategory;
	}

	public void setInterestCategory(String interestCategory) {
		this.interestCategory = interestCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceCatInterest() {
		return priceCatInterest;
	}

	public void setPriceCatInterest(BigDecimal priceCatInterest) {
		this.priceCatInterest = priceCatInterest;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public List<ImageModel> getImage_id() {
		return image_id;
	}

	public void setImage_id(List<ImageModel> image_id) {
		this.image_id = image_id;
	}

	public List<CategoryModel> getProp_category() {
		return prop_category;
	}

	public void setProp_category(List<CategoryModel> prop_category) {
		this.prop_category = prop_category;
	}

	public List<PersonModel> getPersonId() {
		return personId;
	}

	public void setPersonId(List<PersonModel> personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Proposition [propositionId=" + propositionId + ", city=" + city + ", description=" + description
				+ ", interestCategory=" + interestCategory + ", price=" + price + ", priceCatInterest="
				+ priceCatInterest + ", state=" + state + ", title=" + title + ", totalPrice=" + totalPrice
				+ ", zipCode=" + zipCode + ", publish_date=" + publish_date + ", image_id=" + image_id
				+ ", prop_category=" + prop_category + ", personId=" + personId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image_id == null) ? 0 : image_id.hashCode());
		result = prime * result + ((interestCategory == null) ? 0 : interestCategory.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceCatInterest == null) ? 0 : priceCatInterest.hashCode());
		result = prime * result + ((prop_category == null) ? 0 : prop_category.hashCode());
		result = prime * result + ((propositionId == null) ? 0 : propositionId.hashCode());
		result = prime * result + ((publish_date == null) ? 0 : publish_date.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image_id == null) {
			if (other.image_id != null)
				return false;
		} else if (!image_id.equals(other.image_id))
			return false;
		if (interestCategory == null) {
			if (other.interestCategory != null)
				return false;
		} else if (!interestCategory.equals(other.interestCategory))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceCatInterest == null) {
			if (other.priceCatInterest != null)
				return false;
		} else if (!priceCatInterest.equals(other.priceCatInterest))
			return false;
		if (prop_category == null) {
			if (other.prop_category != null)
				return false;
		} else if (!prop_category.equals(other.prop_category))
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
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}






}