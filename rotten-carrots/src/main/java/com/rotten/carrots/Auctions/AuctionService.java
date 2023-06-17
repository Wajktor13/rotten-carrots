package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    AuctionRepository auctionRepository;

    public AuctionService(){
    }

    public AuctionService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> getAll() {
        return auctionRepository.findAll();
    }

    public List<Auction> getByPriceBetween(double minPrice, double maxPrice){
        return auctionRepository.findByPrices(minPrice, maxPrice);
    }

    public List<Auction> getAuctionsByGame(Game game){
        return auctionRepository.findByGame(game);
    }

    public List<Auction> getAuctionsByGenre(String genre){
        return  auctionRepository.findByGameGenre(genre);
    }

    public List<Auction> getActive(){
        return auctionRepository.findActive();
    }

    public Optional<Auction> getAuctionByID(String id) {
        return auctionRepository.findById(id);
    }

    public ResponseEntity<?> deleteAuctionByID(String id) {
        var entity = auctionRepository.findById(id);
        if(entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        auctionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
