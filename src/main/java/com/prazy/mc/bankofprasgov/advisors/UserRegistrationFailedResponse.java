package com.prazy.mc.bankofprasgov.advisors;

import java.io.Serializable;

public class UserRegistrationFailedResponse extends APIException implements Serializable {
	
	public UserRegistrationFailedResponse(Integer errorReasonCode, String errorMessage) {
		super(errorReasonCode, errorMessage);
	}

	private static final long serialVersionUID = -1969245353065956762L;
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserRegistrationFailedResponse [userName=" + userName + "]";
	}
	
}
