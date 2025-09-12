package com.prazy.mc.bankofprasgov.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.prazy.mc.bankofprasgov.utils.StringUtils;

@Configuration
public class SESConfig {
	
	private String aKey = StringUtils.getSESaKey();
	
	private String sKey = StringUtils.getSESsKey();
	
	@Value("${ses.end-point.url}")
	private String awsSESEndPointUrl;
	
	@Value("${amazon.region}")
	private String awsRegion;
	
	@Bean
	public AmazonSimpleEmailService getSESClient() {
		return createSESClient();
	}
	
	public AmazonSimpleEmailService createSESClient() {
		
	      AmazonSimpleEmailService client = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
					.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("email-smtp.us-east-2.amazonaws.com", awsRegion))
					.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(aKey, sKey)))
					.build();
	      
	      return client;
	}
	

}
