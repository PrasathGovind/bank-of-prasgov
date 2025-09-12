package com.prazy.mc.bankofprasgov.advisors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prazy.mc.bankofprasgov.constants.ErrorConstants;

@RestControllerAdvice
@RequestMapping("/")
public class ExceptionAdvisor {
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorResponse> handleAPIExceptions(APIException exception){
		
		ErrorResponse failureResponse = new ErrorResponse(400,"Error");
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if(exception.getErrorReasonCode() == ErrorConstants.REQUEST_JSON_VALIDATION_FAILURE){
			status = HttpStatus.BAD_REQUEST;
			failureResponse = new ErrorResponse(400,"Unable to validate the Json request!");
		}else if(exception.getErrorReasonCode() == ErrorConstants.LOAN_APPLICATION_REJECTED){
			status = HttpStatus.UNPROCESSABLE_ENTITY;
			failureResponse = new ErrorResponse(422,"Your loan is not approved! Please check the loan details and try later!");
		}else if(exception.getErrorReasonCode() == ErrorConstants.USER_REGISTRATION_REJECTED){
			status = HttpStatus.BAD_REQUEST;
			failureResponse = new ErrorResponse(400, "Unable to register User!");
		}
		
		if(exception.getErrorMessage()!=null && !exception.getErrorMessage().isEmpty())
			failureResponse.setErrorMessage(exception.getErrorMessage());
		
		return new ResponseEntity<ErrorResponse>(failureResponse, status);
	}

}
