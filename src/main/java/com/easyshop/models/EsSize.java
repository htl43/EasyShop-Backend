package com.easyshop.models;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "es_size")
public class EsSize {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="sizeId")
	private int id;
	
	@Column(nullable = false, unique = true)
	private String sizename;
	
//	@OneToMany(mappedBy = "sizeId",fetch = FetchType.EAGER)
//	private List<EsProduct> esProductList;
	
	//constructor
	public EsSize() {
		super();
		
	}
	
	public EsSize( String sizename) {
		super();
		this.sizename = sizename;
	}

	public EsSize(int id, String sizename) {
		super();
		this.id = id;
		this.sizename = sizename;
	}
	
	

//	public EsSize(int id, String sizename, List<EsProduct> esProductList) {
//		super();
//		this.id = id;
//		this.sizename = sizename;
//		this.esProductList = esProductList;
//	}
//	
//	
//
//	public EsSize(String sizename, List<EsProduct> esProductList) {
//		super();
//		this.sizename = sizename;
//		this.esProductList = esProductList;
//	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSizename() {
		return sizename;
	}

	public void setSizename(String sizename) {
		this.sizename = sizename;
	}
	
	

//	public List<EsProduct> getEsProductList() {
//		return esProductList;
//	}
//
//	public void setEsProductList(List<EsProduct> esProductList) {
//		this.esProductList = esProductList;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((esProductList == null) ? 0 : esProductList.hashCode());
//		result = prime * result + id;
//		result = prime * result + ((sizename == null) ? 0 : sizename.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		EsSize other = (EsSize) obj;
//		if (esProductList == null) {
//			if (other.esProductList != null)
//				return false;
//		} else if (!esProductList.equals(other.esProductList))
//			return false;
//		if (id != other.id)
//			return false;
//		if (sizename == null) {
//			if (other.sizename != null)
//				return false;
//		} else if (!sizename.equals(other.sizename))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "EsSize [id=" + id + ", sizename=" + sizename + ", esProductList=" + esProductList + "]";
//	}

	
	
	
	
	

}
