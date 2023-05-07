package com.rotten.carrots;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("com.rotten.carrots")
public class RottenCarrotsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RottenCarrotsApplication.class, args);
    }

}
