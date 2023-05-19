package com.rotten.carrots.Auctions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public List<Auction> getAll() {
        return auctionRepository.findAll();
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
