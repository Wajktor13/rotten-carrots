package com.rotten.carrots.Review;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReviewRepository extends MongoRepository<Review, String> {
}
