package com.bah.msd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsdProjectDataServiceApplication {

	public static void main(String[] args) {
		System.out.println("Starting service ......");
		SpringApplication.run(MsdProjectDataServiceApplication.class, args);
	}

}
