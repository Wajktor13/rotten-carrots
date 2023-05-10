package com.rotten.carrots.Marketplace;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketplaceRepository extends MongoRepository<Marketplace, String> {
}
