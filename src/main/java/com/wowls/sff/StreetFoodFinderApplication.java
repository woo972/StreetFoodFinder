package com.wowls.sff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.wowls.sff"})
public class StreetFoodFinderApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(StreetFoodFinderApplication.class, args);
		
	}
}
