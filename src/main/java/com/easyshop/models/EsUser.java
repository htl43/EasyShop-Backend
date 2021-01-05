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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "es_user")
public class EsUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(nullable = false, unique=true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(name="register_date")
	private Date registedDate;
	
	@Column(name="last_login_date")
	private Date lastLoginDate;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_contact_id")
	@JsonBackReference
	private EsUserContact userContact;

	public EsUser() {
		super();
	}

	public EsUser(int id, String username, String password, Date registedDate, Date lastLoginDate,
			EsUserContact userContact) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.registedDate = registedDate;
		this.lastLoginDate = lastLoginDate;
		this.userContact = userContact;
	}

	public EsUser(String username, String password, Date registedDate, Date lastLoginDate, EsUserContact userContact) {
		super();
		this.username = username;
		this.password = password;
		this.registedDate = registedDate;
		this.lastLoginDate = lastLoginDate;
		this.userContact = userContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistedDate() {
		return registedDate;
	}

	public void setRegistedDate(Date registedDate) {
		this.registedDate = registedDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public EsUserContact getUserContact() {
		return userContact;
	}

	public void setUserContact(EsUserContact userContact) {
		this.userContact = userContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lastLoginDate == null) ? 0 : lastLoginDate.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registedDate == null) ? 0 : registedDate.hashCode());
		result = prime * result + ((userContact == null) ? 0 : userContact.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		EsUser other = (EsUser) obj;
		if (id != other.id)
			return false;
		if (lastLoginDate == null) {
			if (other.lastLoginDate != null)
				return false;
		} else if (!lastLoginDate.equals(other.lastLoginDate))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registedDate == null) {
			if (other.registedDate != null)
				return false;
		} else if (!registedDate.equals(other.registedDate))
			return false;
		if (userContact == null) {
			if (other.userContact != null)
				return false;
		} else if (!userContact.equals(other.userContact))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EsUser [id=" + id + ", username=" + username + ", password=" + password + ", registedDate="
				+ registedDate + ", lastLoginDate=" + lastLoginDate + ", userContact=" + userContact + "]";
	}
	
	
	
	
	
   

	
	
	
	

}
