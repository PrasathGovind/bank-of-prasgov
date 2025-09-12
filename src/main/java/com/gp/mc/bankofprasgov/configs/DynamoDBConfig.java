package com.gp.mc.bankofprasgov.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.gp.mc.bankofprasgov.utils.StringUtils;

@Configuration
public class DynamoDBConfig {
	
	private String aKey = StringUtils.getDynamoDBaKey();
	
	private String sKey = StringUtils.getDynamoDBsKey();
	
	@Value("${amazon.region}")
	private String awsRegion;
	
	@Value("${amazon.end-point.url}")
	private String awsDynamoDbEndpoint;
	
	
	@Bean
	public DynamoDB dynamoDB() {
		return new DynamoDB(amazonDynamoDBConfig());
	}
	
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());		
	}
	
	public AmazonDynamoDB amazonDynamoDBConfig() {
		
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDbEndpoint, awsRegion))
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(aKey, sKey)))
			.build();
		
		return amazonDynamoDB;
	}

	@Override
	public String toString() {
		return "DynamoDBConfig [aKey=" + aKey + ", sKey=" + sKey + ", awsRegion="
				+ awsRegion + ", awsDynamoDbEndpoint=" + awsDynamoDbEndpoint + "]";
	}
	
}
