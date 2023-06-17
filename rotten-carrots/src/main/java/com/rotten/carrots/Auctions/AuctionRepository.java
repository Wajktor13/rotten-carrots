package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends MongoRepository<Auction, String> {

    @Query("{ 'price': { $gte: ?0, $lte: ?1 } }")
    List<Auction> findByPrices(double minPrice, double maxPrice);

   // @Query("{ 'game': ?0 }")
    List<Auction> findByGame(Game game);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'games', localField: 'game', foreignField: '_id', as: 'game' } }",
            "{ $match: { 'game.$genre': ?0 } }"
    })
    List<Auction> findByGameGenre(String genre);

    @Query("{ 'isActive': true }")
    List<Auction> findActive();
}
