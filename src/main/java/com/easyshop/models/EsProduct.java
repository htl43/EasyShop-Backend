package com.easyshop.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="es_product")
public class EsProduct {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private int productId;
	
	@Column(nullable = false, unique = true)
	private int sku;
	
	@Column(nullable =false)
	private String productName;
	
	private String metaTitle;
	private String description;
	
	@Column(nullable = false, unique = true)
	private String modelNo;
	
	@Column(nullable = false)
	private double unitPrice;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "sizeId")
	private  EsSize sizeId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "colorId")
	private EsColor colorId ;
	
	private double discount;
	private int unitWeight;
	private int onOrder;
	private int stockQuantity;
	private boolean isProductAvailabe;
	private boolean isDiscountAvailable;
	private Date createDate;
	private int picture;
	private int ranking;
	private String note;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private EsCategory categoryId;
	
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<EsCart> cartItems;
	
	public EsProduct() {
		super();
		
	}

	public EsProduct(int productId) {
		super();
		this.productId = productId;
	}

	public EsProduct(int productId, int sku, String productName, String metaTitle, String description, String modelNo,
			double unitPrice, EsSize sizeId, EsColor colorId, double discount, int unitWeight, int onOrder,
			int stockQuantity, boolean isProductAvailabe, boolean isDiscountAvailable, Date createDate, int picture,
			int ranking, String note, EsCategory categoryId) {
		super();
		this.productId = productId;
		this.sku = sku;
		this.productName = productName;
		this.metaTitle = metaTitle;
		this.description = description;
		this.modelNo = modelNo;
		this.unitPrice = unitPrice;
		this.sizeId = sizeId;
		this.colorId = colorId;
		this.discount = discount;
		this.unitWeight = unitWeight;
		this.onOrder = onOrder;
		this.stockQuantity = stockQuantity;
		this.isProductAvailabe = isProductAvailabe;
		this.isDiscountAvailable = isDiscountAvailable;
		this.createDate = createDate;
		this.picture = picture;
		this.ranking = ranking;
		this.note = note;
		this.categoryId = categoryId;
	}

	public EsProduct(int sku, String productName, String metaTitle, String description, String modelNo,
			double unitPrice, EsSize sizeId, EsColor colorId, double discount, int unitWeight, int onOrder,
			int stockQuantity, boolean isProductAvailabe, boolean isDiscountAvailable, Date createDate, int picture,
			int ranking, String note, EsCategory categoryId) {
		super();
		this.sku = sku;
		this.productName = productName;
		this.metaTitle = metaTitle;
		this.description = description;
		this.modelNo = modelNo;
		this.unitPrice = unitPrice;
		this.sizeId = sizeId;
		this.colorId = colorId;
		this.discount = discount;
		this.unitWeight = unitWeight;
		this.onOrder = onOrder;
		this.stockQuantity = stockQuantity;
		this.isProductAvailabe = isProductAvailabe;
		this.isDiscountAvailable = isDiscountAvailable;
		this.createDate = createDate;
		this.picture = picture;
		this.ranking = ranking;
		this.note = note;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public EsSize getSizeId() {
		return sizeId;
	}

	public void setSizeId(EsSize sizeId) {
		this.sizeId = sizeId;
	}

	public EsColor getColorId() {
		return colorId;
	}

	public void setColorId(EsColor colorId) {
		this.colorId = colorId;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(int unitWeight) {
		this.unitWeight = unitWeight;
	}

	public int getOnOrder() {
		return onOrder;
	}

	public void setOnOrder(int onOrder) {
		this.onOrder = onOrder;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


	public boolean getIsProductAvailabe() {
		return isProductAvailabe;
	}

	public void setProductAvailabe(boolean isProductAvailabe) {
		this.isProductAvailabe = isProductAvailabe;
	}

	public boolean getIsDiscountAvailable() {
		return isDiscountAvailable;
	}

	public void setDiscountAvailable(boolean isDiscountAvailable) {
		this.isDiscountAvailable = isDiscountAvailable;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	public int getPicture() {
		return picture;
	}

	public void setPicture(int picture) {
		this.picture = picture;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public EsCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(EsCategory categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((colorId == null) ? 0 : colorId.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (isDiscountAvailable ? 1231 : 1237);
		result = prime * result + (isProductAvailabe ? 1231 : 1237);
		result = prime * result + ((metaTitle == null) ? 0 : metaTitle.hashCode());
		result = prime * result + ((modelNo == null) ? 0 : modelNo.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + onOrder;
		result = prime * result + picture;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ranking;
		result = prime * result + ((sizeId == null) ? 0 : sizeId.hashCode());
		result = prime * result + sku;
		result = prime * result + stockQuantity;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + unitWeight;
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
		EsProduct other = (EsProduct) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (colorId == null) {
			if (other.colorId != null)
				return false;
		} else if (!colorId.equals(other.colorId))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (isDiscountAvailable != other.isDiscountAvailable)
			return false;
		if (isProductAvailabe != other.isProductAvailabe)
			return false;
		if (metaTitle == null) {
			if (other.metaTitle != null)
				return false;
		} else if (!metaTitle.equals(other.metaTitle))
			return false;
		if (modelNo == null) {
			if (other.modelNo != null)
				return false;
		} else if (!modelNo.equals(other.modelNo))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (onOrder != other.onOrder)
			return false;
		if (picture != other.picture)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (ranking != other.ranking)
			return false;
		if (sizeId == null) {
			if (other.sizeId != null)
				return false;
		} else if (!sizeId.equals(other.sizeId))
			return false;
		if (sku != other.sku)
			return false;
		if (stockQuantity != other.stockQuantity)
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		if (unitWeight != other.unitWeight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EsProduct [productId=" + productId + ", sku=" + sku + ", productName=" + productName + ", metaTitle="
				+ metaTitle + ", description=" + description + ", modelNo=" + modelNo + ", unitPrice=" + unitPrice
				+ ", sizeId=" + sizeId + ", colorId=" + colorId + ", discount=" + discount + ", unitWeight="
				+ unitWeight + ", onOrder=" + onOrder + ", stockQuantity=" + stockQuantity + ", isProductAvailabe="
				+ isProductAvailabe + ", isDiscountAvailable=" + isDiscountAvailable + ", createDate=" + createDate
				+ ", picture=" + picture + ", ranking=" + ranking + ", note=" + note + ", categoryId=" + categoryId
				+ "]";
	}

	
}
