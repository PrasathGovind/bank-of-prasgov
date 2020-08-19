package com.prazy.mc.bankofprazy.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.prazy.mc.bankofprazy.models.LoanRequestDTO;

@Repository
public class LoanDAO {
	
	@Autowired
	DynamoDBMapper dynamoDBMapper;
	
	
	public void saveLoanRequest(LoanRequestDTO loanRequestDTO) {
		
		dynamoDBMapper.save(loanRequestDTO);
		
	}

}
