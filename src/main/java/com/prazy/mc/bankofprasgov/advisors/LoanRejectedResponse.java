package com.prazy.mc.bankofprasgov.advisors;

import java.io.Serializable;

public class LoanRejectedResponse extends APIException implements Serializable{
	
	public LoanRejectedResponse(Integer errorReasonCode, String errorMessage) {
		super(errorReasonCode, errorMessage);
	}

	private static final long serialVersionUID = -4277585524944249429L;
	
	private String userName;
	
	private String emailId;

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
		return "LoanRejectedResponse [userName=" + userName + ", emailId=" + emailId + "]";
	}


}
