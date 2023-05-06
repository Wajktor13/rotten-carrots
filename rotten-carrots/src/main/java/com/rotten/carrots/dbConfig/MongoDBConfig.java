package com.rotten.carrots.dbConfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.rotten.carrots.User.User;
import com.rotten.carrots.User.UserRepository;


@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
            userRepository.save(new User("Peter", "Development"));
            userRepository.save(new User("Sam", "Operations"));
        };
    }

}
