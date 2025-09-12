package com.gp.mc.bankofprasgov.beans;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 7062668895263513998L;

	private String userId;
	
	private String mobileNumber;
	
	private String userName;
	
	private String emailId;

	public String getUserId() {
		return userId;									
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", mobileNumber=" + mobileNumber + ", userName=" + userName + ", emailId="
				+ emailId + "]";
	}

}
