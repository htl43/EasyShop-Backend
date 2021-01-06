package com.easyshop.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "es_order")
public class EsOrder {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
		
	@Column(nullable = false)
	private String productName;
		
	@Column(nullable = false)
	private int totalFinal;
	
	@Column(nullable = false)
	private Date lastLoginDate;
	
//	@ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name = "cartId")
//	private EsCart cart;
		
	
}
