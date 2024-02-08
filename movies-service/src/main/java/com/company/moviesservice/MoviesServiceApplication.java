package com.company.moviesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.company.moviesservice.*"})
@EntityScan("com.company.moviesservice.domain.*")  
public class MoviesServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}

}
