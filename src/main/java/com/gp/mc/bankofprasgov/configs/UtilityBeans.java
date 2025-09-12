package com.gp.mc.bankofprasgov.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class UtilityBeans {
	
	@Bean
	public Gson registerGson() {
		return new Gson();
	}

}
