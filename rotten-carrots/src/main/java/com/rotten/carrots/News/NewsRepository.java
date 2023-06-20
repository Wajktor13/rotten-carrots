package com.rotten.carrots.News;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {

    @Query("{ 'publicationDate': { $gte: ?0, $lte: ?1 } }")
    List<News> findBetweenDates(Date from, Date to);

    List<News> findTop10ByOrderByPublicationDateDesc();

    @Aggregation(value = {
            "{ '$sort' : { 'publicationDate' : -1 } }",
            "{ '$limit' : ?0 }"
    })
    List<News> findLatestNews(int limit);

    List<News> findByAuthor(String author);

    @Aggregation(pipeline = {
            "{$match: {$and: [{author: ?0}, {publicationDate: {$gte: ?1}}, " +
                    "{publicationDate: {$lt: ?2}}]}}",
            "{$sort: {publicationDate: -1}}"
    })
    List<News> findNewsByAuthorAndDate(String author, Date startDate, Date endDate);

    @Query("{'author': {$regex: '^?0', $options: 'i'}}")
    List<News> findByAuthorStartingWith(String letter);

    @Aggregation(pipeline = {
            "{$match: {title: ?0}}",
            "{$sort: {publicationDate: -1}}"
    })
    List<News> findNewsByTitle( String title);

    List<News> findNewsByOrderByAuthor();
    List<News> findNewsByOrderByAuthorDesc();

    @Query("{'content': {$regex: '?0', $options: 'i'}}")
    List<News> getByContentFragment(String fragment);

    @Query("{'author': {$regex: '^?1', $options: 'i'}, " +
            "'content': {$regex: '?0', $options: 'i'}}")
    List<News> findByAuthorAndContent(String content, String author);
}
