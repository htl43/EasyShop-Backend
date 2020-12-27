package com.easyshop.models;

import java.util.Date;

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

@Entity
@Table(name = "es_user")
public class UserLoginProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	//private int contactId;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	private Date registedDate;
	private Date lastLoginDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userContactId")
	private UserRegister userRegister;
	
	// Constructor
	public UserLoginProfile() {
		super();
		
	}

	public UserLoginProfile(int id, String username, String password, Date registedDate, Date lastLoginDate,
			UserRegister userRegister) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.registedDate = registedDate;
		this.lastLoginDate = lastLoginDate;
		this.userRegister = userRegister;
	}

	public UserLoginProfile(String username, String password, Date registedDate, Date lastLoginDate,
			UserRegister userRegister) {
		super();
		this.username = username;
		this.password = password;
		this.registedDate = registedDate;
		this.lastLoginDate = lastLoginDate;
		this.userRegister = userRegister;
	}
	
	//getter and setter

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

	public UserRegister getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lastLoginDate == null) ? 0 : lastLoginDate.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registedDate == null) ? 0 : registedDate.hashCode());
		result = prime * result + ((userRegister == null) ? 0 : userRegister.hashCode());
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
		UserLoginProfile other = (UserLoginProfile) obj;
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
		if (userRegister == null) {
			if (other.userRegister != null)
				return false;
		} else if (!userRegister.equals(other.userRegister))
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
		return "UserLoginProfile [id=" + id + ", username=" + username + ", password=" + password + ", registedDate="
				+ registedDate + ", lastLoginDate=" + lastLoginDate + ", userRegister=" + userRegister + "]";
	}
    
	
	
	
   

	
	
	
	

}
