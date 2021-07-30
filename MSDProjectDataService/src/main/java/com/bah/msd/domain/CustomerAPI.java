package com.bah.msd.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.repository.InMemoryCustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	
	@Autowired
	private InMemoryCustomerRepository repo;

	@GetMapping
	public Collection<Customer> getAll() {
		return repo.getCustomerList();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		Customer customer = null;
		
		Collection<Customer> customers = getAll();
		for (int i = 0; i < customers.size(); i++) {
			if (((ArrayList<Customer>) customers).get(i).getId() == id) {
				customer = ((ArrayList<Customer>) customers).get(i);
			}
		}
		return customer;
	}

}
