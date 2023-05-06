package com.rotten.carrots.News;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {

    @Query("{ 'publicationDate': { $gte: ?0, $lte: ?1 } }")
    List<News> findBetweenDates(Date from, Date to);
}
