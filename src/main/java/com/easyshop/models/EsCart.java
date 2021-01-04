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
	private int finalPrice;
	
	@Column(nullable = false)
	private Date dateAdded;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private EsUserContact userId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="productId")
	private EsProduct product;
	
	@OneToMany(mappedBy="EsOrder", fetch=FetchType.EAGER)
	private List<EsOrder> orderedProducts;

	public EsCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EsCart(int cartId, int finalPrice, Date dateAdded, EsUserContact userId, List<EsOrder> orderedProducts) {
		super();
		this.cartId = cartId;
		this.finalPrice = finalPrice;
		this.dateAdded = dateAdded;
		this.userId = userId;
		this.orderedProducts = orderedProducts;
	}

	public EsCart(int finalPrice, Date dateAdded, EsUserContact userId, List<EsOrder> orderedProducts) {
		super();
		this.finalPrice = finalPrice;
		this.dateAdded = dateAdded;
		this.userId = userId;
		this.orderedProducts = orderedProducts;
	}

	@Override
	public String toString() {
		return "EsCart [cartId=" + cartId + ", finalPrice=" + finalPrice + ", dateAdded=" + dateAdded + ", userId="
				+ userId + ", orderedProducts=" + orderedProducts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + finalPrice;
		result = prime * result + ((orderedProducts == null) ? 0 : orderedProducts.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (finalPrice != other.finalPrice)
			return false;
		if (orderedProducts == null) {
			if (other.orderedProducts != null)
				return false;
		} else if (!orderedProducts.equals(other.orderedProducts))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public EsUserContact getUserId() {
		return userId;
	}

	public void setUserId(EsUserContact userId) {
		this.userId = userId;
	}

	public List<EsOrder> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<EsOrder> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	
	
	
}
