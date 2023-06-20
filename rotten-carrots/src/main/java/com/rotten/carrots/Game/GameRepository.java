package com.rotten.carrots.Game;

import com.rotten.carrots.News.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {

    @Query("{ 'genre': { $eq: ?0 } }")
    List<Game> findByGenre(String genre);

    List<Game> findGamesByOrderByTitle();

    List<Game> findGamesByTitle(String title);

    @Query("{ 'releaseDate': { $gte: ?0, $lte: ?1 } }")
    List<Game> findBetweenDates(Date from, Date to);


    @Query("{'developer': {$regex: '?0', $options: 'i'}}")
    List<Game> findGamesByDeveloper(String name);

    @Query("{'description': {$regex: '?0', $options: 'i'}}")
    List<Game> findGamesWithDescriptionFragment(String content);
}
