package com.tcs.group1.bean;

public class Customer {
	
	private String id;
	private String name;
	private String address;
	private String email;
	private int contactNo;
	
	// getter and setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Customer(String id, String name, String address, String email, int contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
	}
	
	public Customer() {
		
	}
	///
	
}
