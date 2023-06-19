package com.rotten.carrots.User;

import com.rotten.carrots.Auctions.Auction;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Aggregation(pipeline = {
            "{$match: { '_id': ?0 }}",
            "{$unwind: '$auctions'}",
            "{$match: { 'auctions.isActive': true }}",
            "{$group: { _id: '$_id', auctions: { $push: '$auctions' } }}"
    })
    Optional<User> findUserActiveAuctions(String userId);

    @Aggregation(pipeline = {
            "{$match: { '_id': ?0 }}",
            "{$unwind: '$auctions'}",
            "{$match: { 'auctions.isActive': false }}",
            "{$group: { _id: '$_id', auctions: { $push: '$auctions' } }}"
    })
    Optional<User> findUserFinishedAuctions(String userId);

    @Query("{'nickname':  ?0}")
    Optional<User> findUserByNickname(String nickname);
}