package com.rotten.carrots.Review;

import com.rotten.carrots.News.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;


public interface ReviewRepository extends MongoRepository<Review, String> {

    //@Query("{ 'gameID': { $eq: ?0} }")
    List<Review> findByGameID(String gameID);
}
