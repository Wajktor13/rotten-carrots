package com.rotten.carrots.Game;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {

    @Query("{ 'genre': { $eq: ?0 } }")
    List<Game> findByGenre(String genre);
}
