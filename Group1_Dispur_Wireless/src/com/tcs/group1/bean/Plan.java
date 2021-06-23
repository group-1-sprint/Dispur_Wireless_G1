package com.tcs.group1.bean;

public class Plan {
	
	private int planId;
	private String planName;
	private String planType;
	private double tariff;
	private int validity;
	private String rental;
	
	//getter and setter
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public String getRental() {
		return rental;
	}
	public void setRental(String rental) {
		this.rental = rental;
	}
	
	//constructor parameterized
	public Plan(int planId, String planName, String planType, double tariff, int validity, String rental) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planType = planType;
		this.tariff = tariff;
		this.validity = validity;
		this.rental = rental;
	}
	
	public Plan() {
		
	}
	///

}
