package com.example.apimongo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class GestiontpeApplication {


	public static void main(String[] args) {
		SpringApplication.run(GestiontpeApplication.class, args);
	}

}
