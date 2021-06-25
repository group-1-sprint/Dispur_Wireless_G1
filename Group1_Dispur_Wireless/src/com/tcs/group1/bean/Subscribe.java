package com.tcs.group1.bean;

public class Subscribe {
	
	private int subId;
	private String custId;
	private int planId;
	private int duration;
	
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Subscribe(int subId, String custId, int planId, int duration) {
		super();
		this.subId = subId;
		this.custId = custId;
		this.planId = planId;
		this.duration = duration;
	}
	
	public Subscribe() {
		
	}
	
	
	

}
