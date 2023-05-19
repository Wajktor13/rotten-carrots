package com.rotten.carrots.Auctions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auctions")
public class AuctionResource {

    private final AuctionService auctionService;

    public AuctionResource(AuctionRepository auctionRepository) {
        this.auctionService = new AuctionService(auctionRepository);
    }

    @GetMapping("/all")
    public List<Auction> getAll() {
        return auctionService.getAll();
    }

    @GetMapping("/{auctionID}")
    public Optional<Auction> getAuctionByID(@PathVariable("auctionID") String id) {
        return auctionService.getAuctionByID(id);
    }

    @DeleteMapping("/{auctionID}")
    public ResponseEntity<?> deleteAuction(@PathVariable("auctionID") String id) {
        return auctionService.deleteAuctionByID(id);
    }
}
