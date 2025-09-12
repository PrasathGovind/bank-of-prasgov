package com.prazy.mc.bankofprasgov.advisors;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
	
	private static final long serialVersionUID = -70211703200338573L;

	private Integer errorReasonCode;
	
	private String errorMessage;

	public ErrorResponse(Integer errorReasonCode, String errorMessage) {
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

	@Override
	public String toString() {
		return "ErrorResponse [errorReasonCode=" + errorReasonCode + ", errorMessage=" + errorMessage + "]";
	}
	

}
