package com.company.moviesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.company.moviesservice.*"})
@EntityScan("com.company.moviesservice.domain.*")
@EnableDiscoveryClient
// @EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class MoviesServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}

}
