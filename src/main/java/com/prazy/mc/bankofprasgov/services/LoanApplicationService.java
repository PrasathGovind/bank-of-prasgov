package com.prazy.mc.bankofprasgov.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prazy.mc.bankofprasgov.DAO.LoanDAO;
import com.prazy.mc.bankofprasgov.DAO.UserDAO;
import com.prazy.mc.bankofprasgov.advisors.APIException;
import com.prazy.mc.bankofprasgov.beans.ApplyLoanResponse;
import com.prazy.mc.bankofprasgov.beans.Loan;
import com.prazy.mc.bankofprasgov.beans.LoanRequest;
import com.prazy.mc.bankofprasgov.beans.User;
import com.prazy.mc.bankofprasgov.constants.ErrorConstants;
import com.prazy.mc.bankofprasgov.models.LoanRequestDTO;
import com.prazy.mc.bankofprasgov.utils.EmailUtils;

@Service
public class LoanApplicationService {
	
    Logger logger = LoggerFactory.getLogger(LoanApplicationService.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	LoanDAO loanDAO;
	
	@Autowired
	EmailUtils emailUtils;
	
	public ApplyLoanResponse applyForALoan(LoanRequest loanRequest) {
		
		if(loanRequest==null) {
			throw new APIException(ErrorConstants.LOAN_APPLICATION_REJECTED,"Details are missing in Loan Application!");
		}
		
		if(loanRequest!=null && (loanRequest.getMobileNumber()==null || loanRequest.getMobileNumber().isEmpty()
				|| loanRequest.getEmailId()==null || loanRequest.getEmailId().isEmpty())) {
			throw new APIException(ErrorConstants.LOAN_APPLICATION_REJECTED,"Mandatory details are missing in Loan Application!");
		}
		
		if(loanRequest!=null && (loanRequest.getLoanType()==null || loanRequest.getLoanType().isEmpty())) {
			throw new APIException(ErrorConstants.LOAN_APPLICATION_REJECTED,"Loan Type must be mentioned!");
		}
		
		ApplyLoanResponse applyLoanResponse = new ApplyLoanResponse();
		applyLoanResponse.setMessage("Loan Applied Successfully! You will receive an email with further details!");
		
		//Item userItem = userDAO.getUser(loanRequest.getMobileNumber());
		//System.out.println("User fetched : "+userItem.toJSONPretty());
		
		LoanRequestDTO loanDTO = new LoanRequestDTO();
		loanDTO.setMobileNumber(loanRequest.getMobileNumber());
		loanDTO.setLoanAmount(loanRequest.getLoanAmount());
		loanDTO.setLoanType(loanRequest.getLoanType());
		loanDTO.setTermInYears(loanRequest.getTermInYears());
		
		loanDAO.saveLoanRequest(loanDTO);
		
		emailUtils.sendLoanAppliedEmail(loanRequest.getEmailId());
		
		applyLoanResponse.setUser(new User());
		applyLoanResponse.getUser().setMobileNumber(loanRequest.getMobileNumber());
		
		return applyLoanResponse;
	}
	
	
	public List<Loan> getLoanOptionsAndDetails(){
		
		Loan homeLoan = new Loan();
		
		homeLoan.setLoanType("HOME LOAN");
		homeLoan.setRateOfInterest("9.25 %");
		String[] homeLoanTerms = {"5 years", "10 years", "15 years", "20 years", "25 years", "30 years"};
		homeLoan.setTerms(Arrays.asList(homeLoanTerms));
		homeLoan.setMinimumApplicableLoanAmount("5,00,000 INR");
		
		Loan vehicleLoan = new Loan();
		
		vehicleLoan.setLoanType("CAR LOAN");
		vehicleLoan.setRateOfInterest("12.5 %");
		String[] vehicleLoanTerms = {"5 years", "10 years", "15 years"};
		vehicleLoan.setTerms(Arrays.asList(vehicleLoanTerms));
		vehicleLoan.setMinimumApplicableLoanAmount("1,25,000 INR");
		
		List<Loan> loanOptionsAndDetails = new ArrayList<Loan>(0);
		loanOptionsAndDetails.add(homeLoan);
		loanOptionsAndDetails.add(vehicleLoan);
		
		logger.info("loanOptionsAndDetails : "+loanOptionsAndDetails);

		return loanOptionsAndDetails;
	}

}
