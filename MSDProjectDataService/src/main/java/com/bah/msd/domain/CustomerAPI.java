package com.bah.msd.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	ArrayList<Customer> list = new ArrayList<Customer>();

	public CustomerAPI() {
		Customer c1 = new Customer(1, "Nicholas", "pass", "nichloa@bah.com");
		Customer c2 = new Customer(2, "Alisha", "pass", "alisha@bah.com");
		Customer c3 = new Customer(3, "Carsen", "pass", "carsen@bah.com");
		Customer c4 = new Customer(4, "Julia", "pass", "julie@bah.com");
		Customer c5 = new Customer(5, "Joel", "pass", "joel@bah.com");
		Customer c6 = new Customer(6, "Kimberly", "pass", "kimberly@bah.com");
		Customer c7 = new Customer(7, "Kyle", "pass", "kyle@bah.com");
		Customer c8 = new Customer(8, "Emily", "pass", "emily@bah.com");
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		list.add(c7);
		list.add(c8);
	}

	@GetMapping
	public Collection<Customer> getAll() {
		return this.list;
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		
		Customer customer = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				customer = list.get(i);
			}
		}
		return customer;
	}

}
