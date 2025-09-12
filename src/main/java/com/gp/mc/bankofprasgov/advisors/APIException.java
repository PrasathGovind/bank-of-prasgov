package com.gp.mc.bankofprasgov.advisors;

public class APIException extends RuntimeException{
	
	private static final long serialVersionUID = -1565416955172577832L;

	private Integer errorReasonCode;
	
	private String errorMessage;
	
	public APIException(Integer errorReasonCode, String errorMessage) {
		super();
		this.errorReasonCode = errorReasonCode;
		this.errorMessage = errorMessage;
	}

	public Integer getErrorReasonCode() {
		return errorReasonCode;
	}

	public void setErrorReasonCode(Integer errorReasonCode) {
		this.errorReasonCode = errorReasonCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
