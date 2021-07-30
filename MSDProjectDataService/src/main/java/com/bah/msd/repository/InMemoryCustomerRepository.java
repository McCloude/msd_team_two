package com.bah.msd.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bah.msd.domain.Customer;

public class InMemoryCustomerRepository {
	
	private int maxSearchResults = 30;
	
	private List<Customer> customerData = new ArrayList<>(Arrays.asList(
		new Customer(1, "Nicholas", "pass", "nichloa@bah.com"),
		new Customer(2, "Alisha", "pass", "alisha@bah.com"),
		new Customer(3, "Carsen", "pass", "carsen@bah.com"),
		new Customer(4, "Julia", "pass", "julie@bah.com"),
		new Customer(5, "Joel", "pass", "joel@bah.com"),
		new Customer(6, "Kimberly", "pass", "kimberly@bah.com"),
		new Customer(7, "Kyle", "pass", "kyle@bah.com"),
		new Customer(8, "Emily", "pass", "emily@bah.com")));
		
	public List<Customer> getCustomerData() {
		return customerData;
	}
	
	public void setCustomerData(List<Customer> customerData) {
		this.customerData = customerData;
	}
	
	public int getMaxSearchResults() {
		return maxSearchResults;
	}
	
	public void setMaxSearchResults(int maxSearchResults) {
		this.maxSearchResults = maxSearchResults;
	}
	
	public Customer findById(Long id) {
		return findAll().stream()
				.filter(customer -> customer.getId() == id)
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.isEmpty() ? null : list.get(0)));
	}
	
	public Collection<Customer> findByName(String name) {
	    return findAll().stream()
	            .filter(customer -> customer.getName().equalsIgnoreCase(name))
	            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size() <= maxSearchResults ? list : list.subList(0, maxSearchResults)));		
	}
	
	public Collection<Customer> findByEmail(String email) {
	    return findAll().stream()
	            .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
	            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size() <= maxSearchResults ? list : list.subList(0, maxSearchResults)));		            
	}

	public Collection<Customer> findAll() {
		return Collections.unmodifiableCollection(customerData);
	}

	public long count() {
		return customerData.size();
	}

	public Customer save(Customer customer) {
		// Not implemented
		return null;
	}

	public void delete(Customer customer) {
		// Not implemented
	}

}
