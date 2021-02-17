package com.co.personalsoft.examenreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class ExamenReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenReactiveApplication.class, args);
	}

}
