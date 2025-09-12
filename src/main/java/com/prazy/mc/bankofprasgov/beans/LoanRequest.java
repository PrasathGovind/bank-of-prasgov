package com.prazy.mc.bankofprasgov.beans;

import java.io.Serializable;

public class LoanRequest implements Serializable {
	
	private static final long serialVersionUID = -5100597902304070267L;

	private String mobileNumber;
	
	private String emailId;
	
	private String loanType;
	
	private String loanAmount;
	
	private String termInYears;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getTermInYears() {
		return termInYears;
	}

	public void setTermInYears(String termInYears) {
		this.termInYears = termInYears;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "LoanRequest [mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", loanType=" + loanType
				+ ", loanAmount=" + loanAmount + ", termInYears=" + termInYears + "]";
	}

}
