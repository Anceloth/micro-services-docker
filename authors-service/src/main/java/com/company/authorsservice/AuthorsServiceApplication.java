package com.company.authorsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.company.authorsservice.*"})
@EntityScan("com.company.authorsservice.domain.*")  
public class AuthorsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorsServiceApplication.class, args);
	}

}
