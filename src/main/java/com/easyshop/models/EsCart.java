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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	@JsonBackReference
	private EsUser esUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId")
	private EsProduct product;

	public EsCart() {
		super();
	}

	public EsCart(int cartId, double finalPrice, Date dateAdded, EsUser esUser, EsProduct product) {
		super();
		this.cartId = cartId;
		this.finalPrice = finalPrice;
		this.dateAdded = dateAdded;
		this.esUser = esUser;
		this.product = product;
	}

	public EsCart(double finalPrice, Date dateAdded, EsUser esUser, EsProduct product) {
		super();
		this.finalPrice = finalPrice;
		this.dateAdded = dateAdded;
		this.esUser = esUser;
		this.product = product;
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

	public EsUser getEsUser() {
		return esUser;
	}

	public void setEsUser(EsUser esUser) {
		this.esUser = esUser;
	}

	public EsProduct getProduct() {
		return product;
	}

	public void setProduct(EsProduct product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((esUser == null) ? 0 : esUser.hashCode());
		long temp;
		temp = Double.doubleToLongBits(finalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		EsCart other = (EsCart) obj;
		if (cartId != other.cartId)
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (esUser == null) {
			if (other.esUser != null)
				return false;
		} else if (!esUser.equals(other.esUser))
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

	@Override
	public String toString() {
		return "EsCart [cartId=" + cartId + ", finalPrice=" + finalPrice + ", dateAdded=" + dateAdded + ", esUser="
				+ esUser + ", product=" + product + "]";
	}

	
}
