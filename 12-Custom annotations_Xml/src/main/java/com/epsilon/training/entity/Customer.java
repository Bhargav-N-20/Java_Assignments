package com.epsilon.training.entity;

import com.epsilon.training.annotations.XmlProperty;
import com.epsilon.training.annotations.XmlSerializable;

@XmlSerializable
public class Customer {

	@XmlProperty
	private String name;
	
	@XmlProperty
	private String email;
	
	@XmlProperty
	private String phone;
	
	@XmlProperty
	private Address address;
	
	public Customer() {
		
	}
	

	public Customer(String name, String email, String phone, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
