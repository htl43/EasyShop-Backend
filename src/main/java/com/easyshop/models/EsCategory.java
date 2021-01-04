package com.easyshop.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name= "es_category")
public class EsCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId")
	private int categoryId;
	
	private String categoryName;
	private String description;
	private int pictureId;
	private boolean isActive;
	
	
//	@ManyToMany(mappedBy = "category")
//	private List<EsProduct> esProduct;
	
	
	
	public EsCategory() {
		super();
		
	}

	public EsCategory( String categoryName, String description, int pictureId, boolean isActive) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.pictureId = pictureId;
		this.isActive = isActive;
	}

	public EsCategory(int categoyId, String categoryName, String description, int pictureId, boolean isActive) {
		super();
		this.categoryId = categoyId;
		this.categoryName = categoryName;
		this.description = description;
		this.pictureId = pictureId;
		this.isActive = isActive;
	}

	
	

//	public EsCategory(int categoryId, String categoryName, String description, int pictureId, boolean isActive,
//			List<EsProduct> esProduct) {
//		super();
//		this.categoryId = categoryId;
//		this.categoryName = categoryName;
//		this.description = description;
//		this.pictureId = pictureId;
//		this.isActive = isActive;
//		this.esProduct = esProduct;
//	}
	
	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

//	public List<EsProduct> getEsProduct() {
//		return esProduct;
//	}
//
//	public void setEsProduct(List<EsProduct> esProduct) {
//		this.esProduct = esProduct;
//	}

	public int getCategoyId() {
		return categoryId;
	}


	public void setCategoyId(int categoyId) {
		this.categoryId = categoyId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPictureId() {
		return pictureId;
	}


	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + pictureId;
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
		EsCategory other = (EsCategory) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isActive != other.isActive)
			return false;
		if (pictureId != other.pictureId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EsCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description="
				+ description + ", pictureId=" + pictureId + ", isActive=" + isActive 
				+ "]";
	}


   
	
	
	
	

}
