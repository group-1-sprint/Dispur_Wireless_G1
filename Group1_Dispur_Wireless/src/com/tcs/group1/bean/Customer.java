package com.tcs.group1.bean;

public class Customer {
	
	private String regId;
	private String name;
	private String address;
	private String email;
	private int contactNo;
	
	//getter and setter
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	//constructor
	public Customer(String regId, String name, String address, String email, int contactNo) {
		super();
		this.regId = regId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
	}
	
	public Customer() {
	
	}
	
	
	
}
