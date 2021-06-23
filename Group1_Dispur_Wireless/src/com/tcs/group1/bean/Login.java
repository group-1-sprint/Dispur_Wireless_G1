package com.tcs.group1.bean;

public class Login {
	
	private String logId;
	private String password;
	
	//getter and setter
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//constructor parameterized
	public Login(String logId, String password) {
		super();
		this.logId = logId;
		this.password = password;
	}
	
	public Login() {
		
	}
	///

}
