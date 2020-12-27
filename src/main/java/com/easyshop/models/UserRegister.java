package com.easyshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="es_usercontact")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int userContactId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	public UserRegister() {
		super();
		
	}

	public UserRegister(int userContactId, String firstName, String lastName, String email, String phone,
			String address1, String address2, String city, String state, String zipcode, String country) {
		super();
		this.userContactId = userContactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public UserRegister(String firstName, String lastName, String email, String phone, String address1, String address2,
			String city, String state, String zipcode, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public int getUserContactId() {
		return userContactId;
	}

	public void setUserContactId(int userContactId) {
		this.userContactId = userContactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserRegister [userContactId=" + userContactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + "]";
	}
	
	
	
	
	
	
	

}
