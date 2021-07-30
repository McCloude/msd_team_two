package com.bah.msd.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.domain.Customer;
import com.bah.msd.repository.InMemoryCustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	
	@Autowired
	private InMemoryCustomerRepository repo;

	@GetMapping
	public Collection<Customer> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		return repo.findById(id);
	}
	
	@GetMapping("/name/{customerName}")
	public Collection<Customer> getCustomerByName(@PathVariable("customerName") String name) {
		return repo.findByName(name);
	}
	
	@GetMapping("/email/{customerEmail}")
	public Collection<Customer> getCustomerByEmail(@PathVariable("customerEmail") String email) {
		return repo.findByEmail(email);
	}

}
