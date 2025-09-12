package com.prazy.mc.bankofprasgov.beans;

import java.io.Serializable;
import java.util.List;

public class Loan implements Serializable {
	
	private static final long serialVersionUID = -435820329665736172L;

	private String loanType;
	
	private String rateOfInterest;
	
	private List<String> terms;
	
	private String minimumApplicableLoanAmount;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public List<String> getTerms() {
		return terms;
	}

	public void setTerms(List<String> terms) {
		this.terms = terms;
	}

	public String getMinimumApplicableLoanAmount() {
		return minimumApplicableLoanAmount;
	}

	public void setMinimumApplicableLoanAmount(String minimumApplicableLoanAmount) {
		this.minimumApplicableLoanAmount = minimumApplicableLoanAmount;
	}

	@Override
	public String toString() {
		return "Loan [loanType=" + loanType + ", rateOfInterest=" + rateOfInterest + ", terms=" + terms
				+ ", minimumApplicableLoanAmount=" + minimumApplicableLoanAmount + "]";
	}

}
