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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "es_cart")
public class EsCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@Column(nullable = false)
	private double finalPrice;
	
	@Column(nullable = false)
	private Date dateAdded;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private EsUser esUserId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productId")
	private EsProduct product;
	
//	@OneToMany(mappedBy="EsOrder", fetch=FetchType.EAGER)
//	private List<EsOrder> orderedProducts;

	public EsCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EsCart(int cartId, double finalPrice, Date dateAdded, EsUser esUserId, EsProduct product) {
		super();
		this.cartId = cartId;
		this.finalPrice = finalPrice;
		this.dateAdded = dateAdded;
		this.esUserId = esUserId;
		this.product = product;

	}

	public EsCart(double finalPrice, Date dateAdded, EsUser esUserId, EsProduct product,
			List<EsOrder> orderedProducts) {
		super();
		this.finalPrice = finalPrice;
		this.dateAdded = dateAdded;
		this.esUserId = esUserId;
		this.product = product;

	}



	@Override
	public String toString() {
		return "EsCart [cartId=" + cartId + ", finalPrice=" + finalPrice + ", dateAdded=" + dateAdded + ", esUserId="
				+ esUserId + ", product=" + product + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + cartId;
//		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
//		result = prime * result + ((esUserId == null) ? 0 : esUserId.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(finalPrice);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((orderedProducts == null) ? 0 : orderedProducts.hashCode());
//		result = prime * result + ((product == null) ? 0 : product.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EsCart other = (EsCart) obj;
		if (cartId != other.cartId)
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (esUserId == null) {
			if (other.esUserId != null)
				return false;
		} else if (!esUserId.equals(other.esUserId))
			return false;
		if (Double.doubleToLongBits(finalPrice) != Double.doubleToLongBits(other.finalPrice))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public EsUser getEsUserId() {
		return esUserId;
	}

	public void setEsUserId(EsUser esUserId) {
		this.esUserId = esUserId;
	}

	public EsProduct getProduct() {
		return product;
	}

	public void setProduct(EsProduct product) {
		this.product = product;
	}


	public EsCart(int cartId) {
		super();
		this.cartId = cartId;
	}

	
	
	
	
	
}
