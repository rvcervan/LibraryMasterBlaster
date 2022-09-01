package com.example.LibraryMasterBlaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.*")
@EnableJpaRepositories(basePackages = "com.*")
@EntityScan(basePackages = "com.*")
public class LibraryMasterBlasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMasterBlasterApplication.class, args);
	}

}
