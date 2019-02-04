package com.wowls.sff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages= {"com.wowls.sff"})
@EnableConfigurationProperties({
	FileStorageConfig.class
})
public class StreetFoodFinderApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(StreetFoodFinderApplication.class, args);
	}
	
	
}
