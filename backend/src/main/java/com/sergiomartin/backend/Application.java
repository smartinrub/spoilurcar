package com.sergiomartin.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 
 * @author Sergio Martin Rubio
 * @date 09-Oct-2017
 *
 */
@SpringBootApplication
@EnableMongoRepositories("com.sergiomartin.backend.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}