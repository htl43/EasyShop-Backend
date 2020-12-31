package com.easyshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "es_size")
public class EsSize {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String sizename;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((sizename == null) ? 0 : sizename.hashCode());
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
		EsSize other = (EsSize) obj;
		if (id != other.id)
			return false;
		if (sizename == null) {
			if (other.sizename != null)
				return false;
		} else if (!sizename.equals(other.sizename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EsSize [id=" + id + ", sizename=" + sizename + "]";
	}
	
	
	
	

}
