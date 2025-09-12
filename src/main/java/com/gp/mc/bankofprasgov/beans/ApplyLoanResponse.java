package com.gp.mc.bankofprasgov.beans;

import java.io.Serializable;

public class ApplyLoanResponse implements Serializable {
	
	private static final long serialVersionUID = -9211881386547769068L;
	
	private String message;

	private Loan loan;
	
	private User user;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ApplyLoanResponse [message=" + message + ", loan=" + loan + ", user=" + user + "]";
	}

}
