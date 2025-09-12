package com.prazy.mc.bankofprasgov.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.prazy.mc.bankofprasgov.advisors.APIException;
import com.prazy.mc.bankofprasgov.beans.ApplyLoanResponse;
import com.prazy.mc.bankofprasgov.beans.Loan;
import com.prazy.mc.bankofprasgov.beans.LoanRequest;
import com.prazy.mc.bankofprasgov.services.LoanApplicationService;

@RestController
public class LoanApplication {
	
	@Autowired
	LoanApplicationService loanApplicationService;
	
	@Autowired
	private Gson gson;
	
	@GetMapping(path="/loan/details", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getLoanOptionsAndDetails(){
		
		List<Loan> loanOptionsAndDetails = loanApplicationService.getLoanOptionsAndDetails();
		
		String loanOptionsAndDetailsJson = gson.toJson(loanOptionsAndDetails);
		
		ResponseEntity<String> response = new ResponseEntity<String>(loanOptionsAndDetailsJson, HttpStatus.OK);
		
		return response;		
	}
	
	@PostMapping(path="/loan/procurement", consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> applyLoan(@RequestBody LoanRequest loanRequest) throws APIException {
		
		ApplyLoanResponse response = loanApplicationService.applyForALoan(loanRequest);
		
		String jsonReponse = gson.toJson(response);

		return new ResponseEntity<String>(jsonReponse, HttpStatus.OK);
	}

}
