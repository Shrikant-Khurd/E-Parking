package com.epark.epsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = "com.epark")
@EnableJpaRepositories(basePackages = "com.epark.repository")
@EntityScan(basePackages = "com.epark.model")
public class EParkingServicePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EParkingServicePortalApplication.class, args);
		System.out.println("Hello");
	}
}
