package com.bah.msd.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAPI {
	
	@RequestMapping
	public String getMessage() {
		return "Web application configuration correct";
	}
}
