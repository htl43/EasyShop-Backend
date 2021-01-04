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
@Table(name="es_color")
public class EsColor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="colorId")
	private int id;
	
	@Column(nullable = false, unique = true)
	private String colorName;
	
//	@OneToMany(mappedBy = "colorId",fetch = FetchType.EAGER)
//	private List<EsProduct> esColorId;
	
	
	public EsColor() {
		super();
	
	}
    
	
	public EsColor( String colorName) {
		super();
		this.colorName = colorName;
	}

	public EsColor(int id, String colorName) {
		super();
		this.id = id;
		this.colorName = colorName;
	}

	
	

//	public EsColor(int id, String colorName, List<EsProduct> esColorId) {
//		super();
//		this.id = id;
//		this.colorName = colorName;
//		this.esColorId = esColorId;
//	}
//
//	
//	
//
//	public EsColor(String colorName, List<EsProduct> esColorId) {
//		super();
//		this.colorName = colorName;
//		this.esColorId = esColorId;
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

    
	
//	
//	public List<EsProduct> getEsColorId() {
//		return esColorId;
//	}
//
//
//	public void setEsColorId(List<EsProduct> esColorId) {
//		this.esColorId = esColorId;
//	}


//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((colorName == null) ? 0 : colorName.hashCode());
//		result = prime * result + ((esColorId == null) ? 0 : esColorId.hashCode());
//		result = prime * result + id;
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		EsColor other = (EsColor) obj;
//		if (colorName == null) {
//			if (other.colorName != null)
//				return false;
//		} else if (!colorName.equals(other.colorName))
//			return false;
//		if (esColorId == null) {
//			if (other.esColorId != null)
//				return false;
//		} else if (!esColorId.equals(other.esColorId))
//			return false;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//
//
//	@Override
//	public String toString() {
//		return "EsColor [id=" + id + ", colorName=" + colorName + ", esColorId=" + esColorId + "]";
//	}
//

	
	
	

}
