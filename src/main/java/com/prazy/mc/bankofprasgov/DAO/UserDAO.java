package com.prazy.mc.bankofprasgov.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.prazy.mc.bankofprasgov.configs.DynamoDBConfig;
import com.prazy.mc.bankofprasgov.models.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	DynamoDBConfig dynamoDBConfig;
	
	@Autowired
	DynamoDBMapper dynamoDBMapper;
	
	@Autowired
	DynamoDB dynamoDB;
	
	public void registerUser(UserDTO userDTO) {
		
		dynamoDBMapper.save(userDTO);
		
		System.out.println("dynamoDBConfig : "+dynamoDBConfig);
		
	}
	
	public Item getUser(String mobileNumber){
		
		Table table = dynamoDB.getTable("user");
		
		Item item = table.getItem(new GetItemSpec().withPrimaryKey("mobileNumber",mobileNumber));
		
		return item;
	}
	

}
