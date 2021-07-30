package com.bah.msd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bah.msd.repository.InMemoryCustomerRepository;

@Configuration
public class SpringRepositoryConfig {

	@Bean
	public InMemoryCustomerRepository getRepo() {
		return new InMemoryCustomerRepository();
	}
	
}
